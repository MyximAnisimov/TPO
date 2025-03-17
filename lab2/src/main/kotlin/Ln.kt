package itmo.tpo

import kotlin.math.abs

class Ln {
    fun ln(x: Double, eps: Double): Double {
        val y = (x - 1) / (x + 1)
        val y2 = y * y

        return 2 * generateSequence(Pair(y, 1)) { (term, n) ->
            val nextTerm = term * y2 * n / (n + 2)
            Pair(nextTerm, n + 2)
        }
            .takeWhile { abs(it.first) > eps }
            .sumOf { it.first }
    }
}