package itmo.tpo

import kotlin.math.abs
import kotlin.math.pow

class Sin {
    fun sin(x: Double, eps: Double): Double {
        val powX = x.pow(2)
        return generateSequence(Pair(x, 1)) { (term, factN) ->
            val nextTerm = -term * powX / ((factN + 1) * (factN + 2))
            Pair(nextTerm, factN + 2)
        }
            .takeWhile { abs(it.first) > eps }
            .sumOf { it.first }
    }
}