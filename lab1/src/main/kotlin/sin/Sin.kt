package itmo.tpo.sin

import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode

class Sin(val x: BigDecimal, val degree: Int) {

    private val mc = MathContext(1000, RoundingMode.HALF_EVEN)

    fun decomposition(x: BigDecimal, degree: Int): BigDecimal {
        var result = BigDecimal.ZERO
        for (i in 1..degree) {
            val sign = if (i % 2 == 1) BigDecimal.ONE else BigDecimal(-1)
            val term = sign.multiply(x.pow(2 * i - 1, mc), mc)
                .divide(factorial(BigDecimal.ONE, 2 * i - 1), mc)

            result = result.add(term, mc)
        }
        return result
    }

    private fun factorial(counter: BigDecimal, number: Int): BigDecimal {
        return if (number > 0) {
            factorial(counter.multiply(BigDecimal(number), mc), number - 1)
        } else {
            counter
        }
    }
}
