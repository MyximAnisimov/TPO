import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FirstTest {

    @Test
    fun testAddition() {
        val sum = 2 + 2
        assertEquals(4, sum, "Сложение работает некорректно")
    }
}