import itmo.tpo.Function
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import java.sql.DriverManager

@Testcontainers
class DockerTests {


    companion object {
        val dbUrl: String = System.getenv("DB_URL")
        val dbUser: String = System.getenv("DB_USERNAME")
        val dbPassword: String = System.getenv("DB_PASSWORD")

        @Container
        val postgres = PostgreSQLContainer("postgres:17")

        @JvmStatic
        @BeforeAll
        fun setup(): Unit {
            postgres.start()

            System.setProperty(dbUrl, postgres.jdbcUrl)
            System.setProperty(dbUser, postgres.username)
            System.setProperty(dbPassword, postgres.password)

            val connection = DriverManager.getConnection(
                System.getProperty(dbUrl),
                System.getProperty(dbUser),
                System.getProperty(dbPassword)
            )

            val statement = connection.createStatement()
            val resultSet = statement.executeQuery("SELECT 1")
            resultSet.next()
            val result = resultSet.getInt(1)
            Assertions.assertEquals(1, result)

            val createTableStatement = connection.createStatement()
            createTableStatement.execute("CREATE TABLE IF NOT EXISTS math (id INT PRIMARY KEY, reference_result DOUBLE PRECISION, result DOUBLE PRECISION)")

            val insertStatement =
                connection.prepareStatement("INSERT INTO math (id, reference_result, result) VALUES (?, ?, ?)")
            insertStatement.setInt(1, 1)
            insertStatement.setDouble(2, 1.011380846809258)
            insertStatement.setDouble(3, 0.0)
            insertStatement.executeUpdate()

            connection.close()
        }

        @JvmStatic
        @AfterAll
        fun teardown(): Unit {
            postgres.stop()
        }
    }


    @Test
    fun `another test using the same database`() {
        val connection = DriverManager.getConnection(
            System.getProperty(dbUrl),
            System.getProperty(dbUser),
            System.getProperty(dbPassword)
        )
        val statement = connection.createStatement()
        val resultSet = statement.executeQuery("SELECT 2")
        resultSet.next()
        val result = resultSet.getInt(1)

        Assertions.assertEquals(2, result)
        connection.close()
    }

    @Test
    fun `should retrieve value from table by id`() {
        val connection = DriverManager.getConnection(
            System.getProperty(dbUrl),
            System.getProperty(dbUser),
            System.getProperty(dbPassword)
        )
        val idToRetrieve = 1
        val statement = connection.prepareStatement("SELECT reference_result FROM math WHERE id = 1")
        val resultSet = statement.executeQuery()
        Assertions.assertTrue(resultSet.next(), "No row found with id $idToRetrieve")

        val retrievedValue = resultSet.getString("reference_result")
        Assertions.assertEquals("1.011380846809258", retrievedValue)

        connection.close()
    }

    @Test
    fun `should write and retrieve user data correctly`() {
        val userId = 1
        val resultFunc = Function()
        val resultVal = resultFunc.func(2.0, 0.00001)

        writeResultToDatabase(userId, resultVal)

        val retrievedName = retrieveReferencedResultFromDatabase(userId)

        Assertions.assertEquals(retrievedName, resultVal,"Referenced result and calculated result must be equal")
    }


    // Запись данных в бд
    private fun writeResultToDatabase(id: Int, x: Double) {
        val connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)
        val insertStatement = connection.prepareStatement("UPDATE math SET result = ? WHERE id = ?")
        insertStatement.setInt(1, id)
        insertStatement.setDouble(2, x)
        insertStatement.executeUpdate()
        connection.close()
    }

    // Достаёт данные из бд
    private fun retrieveReferencedResultFromDatabase(id: Int): Double {
        val connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)
        val selectStatement = connection.prepareStatement("SELECT reference_result FROM math WHERE id = ?")
        selectStatement.setInt(1, id)
        val resultSet = selectStatement.executeQuery()

        return if (resultSet.next()) {
            resultSet.getDouble("reference_result")
        } else {
            throw NoSuchElementException("User with id $id not found")
        }
        connection.close()
    }
}