package itmo.tpo

import itmo.tpo.cool_story.ChillingState
import itmo.tpo.cool_story.Ford
import itmo.tpo.cool_story.StateContext
import itmo.tpo.hash_table.HashTable
import itmo.tpo.sin.Sin
import java.math.BigDecimal

fun main() {
    val testHashTable = HashTable<String, Int>(10)

    testHashTable.put("Max", 125)
    testHashTable.put("Egor", 252)
    testHashTable.put("Marat", 1001)
    testHashTable.put("Andrew", 666)

    println(testHashTable.get("Max"))
    testHashTable.remove("Max")

    val sin = Sin(BigDecimal(Math.PI), 10)
    println("calculation result of sin(${sin.x}) with first ${sin.degree} members of the series: ${sin.decomposition(sin.x, sin.degree)}")

    testHashTable.put("Egor", 101)
    println(testHashTable)

    val st = StateContext()
    st.state = ChillingState()
    val ford = Ford()
    ford.feel(st, "Около дома")
}