package itmo.tpo

import itmo.tpo.hash_table.HashTable
import itmo.tpo.sin.Sin

fun main() {
    val testHashTable = HashTable<String, Int>(10)

    testHashTable.put("Max", 125)
    testHashTable.put("Egor", 252)
    testHashTable.put("Marat", 1001)
    testHashTable.put("Andrew", 666)

    println(testHashTable.get("Max"))
    testHashTable.remove("Max")

    val sin = Sin(-1.5, 10)
    println("calculation result of sin(${sin.x}) with first ${sin.degree} members of the series: ${sin.decomposition(sin.degree, sin.x)}")

    println(testHashTable)
}