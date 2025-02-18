package itmo.tpo

import itmo.tpo.hash_table.HashTable

fun main() {
    val testHashTable = HashTable<String, Int>(10)

    testHashTable.put("Max", 125)
    testHashTable.put("Egor", 252)
    testHashTable.put("Marat", 1001)
    testHashTable.put("Andrew", 666)

    println(testHashTable.get("Max"))
    testHashTable.remove("Max")

    println(testHashTable)
}