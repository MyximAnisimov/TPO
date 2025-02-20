import itmo.tpo.hash_table.HashTable
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HashTableTest {

    @Test
    fun `put should add element and get should return it`() {
        val table = HashTable<String, Int>()
        table.put("key1", 42)

        assertEquals(42, table.get("key1"))
    }

    @Test
    fun `put should update value for existing key`() {
        val table = HashTable<String, Int>()
        table.put("key1", 42)
        table.put("key1", 99)

        assertEquals(99, table.get("key1"))
    }

    @Test
    fun `remove should delete element`() {
        val table = HashTable<String, Int>()
        table.put("key1", 42)
        table.remove("key1")

        assertNull(table.get("key1"))
    }

    @Test
    fun `get should return null for non-existing key`() {
        val table = HashTable<String, Int>()

        assertNull(table.get("missing"))
    }

    @Test
    fun `should handle hash collisions correctly`() {
        val table = HashTable<Int, Int>(2)

        table.put(1, 10)
        table.put(3, 5)

        assertEquals(10, table.get(1))
        assertEquals(5, table.get(3))
    }

    @Test
    fun `toString should return correct format`() {
        val table = HashTable<String, Int>()
        table.put("x", 10)
        table.put("y", 20)

        val output = table.toString()

        assertTrue(output.contains("x to 10"))
        assertTrue(output.contains("y to 20"))
    }
}