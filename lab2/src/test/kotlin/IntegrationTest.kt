import itmo.tpo.Function
import itmo.tpo.functions.*
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test
import kotlin.test.assertTrue

class IntegrationTest {
    private val eps = 0.00001

    @Test
    fun `test x less or equals 0 branch`() {
        val function = Function().apply {
            tan = object : Tan() { override fun tan(x: Double, eps: Double) = 1.0 }
            sec = object : Sec() { override fun sec(x: Double, eps: Double) = 2.0 }
            csc = object : Csc() { override fun csc(x: Double, eps: Double) = 0.5 }
        }

        val x = -Math.PI / 4
        assertEquals(2.0, function.func(x, 1e-7), 1e-7)
    }

    @Test
    fun `test x bigger than 0 branch`() {
        val function = Function().apply {
            ln = object : Ln() { override fun ln(x: Double, eps: Double) = 1.0 }
            log2 = object : Log(2.0) { override fun log(x: Double, eps: Double) = 2.0 }
            log3 = object : Log(3.0) { override fun log(x: Double, eps: Double) = 3.0 }
            log5 = object : Log(5.0) { override fun log(x: Double, eps: Double) = 5.0 }
            log10 = object : Log(10.0) { override fun log(x: Double, eps: Double) = 10.0 }
        }

        val x = 2.0
        assertEquals(9.6, function.func(x, 1e-7), 1e-7)
    }

    @Test
    fun `test x equals 1 for logarithmic branch`() {
        val function = Function().apply {
            ln = object : Ln() { override fun ln(x: Double, eps: Double) = 0.0 } // ln(1) = 0
            log2 = object : Log(2.0) { override fun log(x: Double, eps: Double) = 0.0 } // log2(1) = 0
            log3 = object : Log(3.0) { override fun log(x: Double, eps: Double) = 0.0 } // log3(1) = 0
            log5 = object : Log(5.0) { override fun log(x: Double, eps: Double) = 0.0 } // log5(1) = 0
            log10 = object : Log(10.0) { override fun log(x: Double, eps: Double) = 0.0 } // log10(1) = 0
        }

        val x = 1.0
        assertTrue(function.func(x, 1e-7).isNaN(), "Деление 0/0 должно возвращать NaN")
    }


    @Test
    fun `test sec division by zero`() {
        val sec = Sec().apply {
            cos = object : Cos() { override fun cos(x: Double, eps: Double) = 0.0 }
        }

        assertTrue(sec.sec(1.0, 1e-7).isNaN(), "sec(π/2) должен возвращать NaN")
    }
}