import itmo.tpo.Function
import itmo.tpo.functions.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import kotlin.math.cos

class IntegrationTest {

    private val eps = 0.00001

    @Test
    fun `test x less or equals 0 branch with mocks`() {
        val tanMock: Tan = mock {
            on { tan(x = -Math.PI / 4, eps = 1e-7) } doReturn 1.0
        }
        val secMock: Sec = mock {
            on { sec(x = -Math.PI / 4, eps = 1e-7) } doReturn 2.0
        }
        val cscMock: Csc = mock {
            on { csc(x = -Math.PI / 4, eps = 1e-7) } doReturn 0.5
        }

        val function = Function().apply {
            tan = tanMock
            sec = secMock
            csc = cscMock
        }

        val x = -Math.PI / 4
        assertEquals(2.0, function.func(x, 1e-7), 1e-7)
    }

    @Test
    fun `test x bigger than 0 branch with mocks`() {
        val lnMock: Ln = mock {
            on { ln(x = 2.0, eps = 1e-7) } doReturn 1.0
        }
        val log2Mock: Log = mock {
            on { log(x = 2.0, eps = 1e-7) } doReturn 2.0
        }
        val log3Mock: Log = mock {
            on { log(x = 2.0, eps = 1e-7) } doReturn 3.0
        }
        val log5Mock: Log = mock {
            on { log(x = 2.0, eps = 1e-7) } doReturn 5.0
        }
        val log10Mock: Log = mock {
            on { log(x = 2.0, eps = 1e-7) } doReturn 10.0
        }

        val function = Function().apply {
            ln = lnMock
            log2 = log2Mock
            log3 = log3Mock
            log5 = log5Mock
            log10 = log10Mock
        }

        val x = 2.0
        assertEquals(9.6, function.func(x, 1e-7), 1e-7)
    }

    @Test
    fun `test x equals 1 for logarithmic branch with mocks`() {
        val lnMock: Ln = mock {
            on { ln(x = 1.0, eps = 1e-7) } doReturn 0.0
        }
        val log2Mock: Log = mock {
            on { log(x = 1.0, eps = 1e-7) } doReturn 0.0
        }
        val log3Mock: Log = mock {
            on { log(x = 1.0, eps = 1e-7) } doReturn 0.0
        }
        val log5Mock: Log = mock {
            on { log(x = 1.0, eps = 1e-7) } doReturn 0.0
        }
        val log10Mock: Log = mock {
            on { log(x = 1.0, eps = 1e-7) } doReturn 0.0
        }

        val function = Function().apply {
            ln = lnMock
            log2 = log2Mock
            log3 = log3Mock
            log5 = log5Mock
            log10 = log10Mock
        }

        val x = 1.0
        assertTrue(function.func(x, 1e-7).isNaN(), "Деление 0/0 должно возвращать NaN")
    }

    @Test
    fun `test sec division by zero with mocks`() {
        val cosMock: Cos = mock {
            on { cos(x = 1.0, eps = 1e-7) } doReturn 0.0
        }

        val sec = Sec().apply {
            cos = cosMock
        }

        assertTrue(sec.sec(1.0, 1e-7).isNaN(), "sec(π/2) должен возвращать NaN")
    }

    @Test
    fun testXLessThanOrEqualsZeroBranchWithMocks() {
        val tanMock: Tan = mock {
            on { tan(x = -Math.PI / 4, eps = eps) } doReturn -1.0
        }
        val secMock: Sec = mock {
            on { sec(x = -Math.PI / 4, eps = eps) } doReturn 1.4142135623730951
        }
        val cscMock: Csc = mock {
            on { csc(x = -Math.PI / 4, eps = eps) } doReturn -1.4142135623730951
        }

        val function = Function().apply {
            tan = tanMock
            sec = secMock
            csc = cscMock
        }
        val x = -Math.PI / 4
        val result = function.func(x, eps)
        assertEquals(0.7071064695751781, result, 0.00001)
    }

    @Test
    fun testXEqualsOneForLogarithmicBranchWithMocks() {
        val lnMock: Ln = mock {
            on { ln(x = 1.0, eps = eps) } doReturn 0.0
        }
        val log2Mock: Log = mock {
            on { log(x = 1.0, eps = eps) } doReturn 0.0
        }
        val log3Mock: Log = mock {
            on { log(x = 1.0, eps = eps) } doReturn 0.0
        }
        val log5Mock: Log = mock {
            on { log(x = 1.0, eps = eps) } doReturn 0.0
        }
        val log10Mock: Log = mock {
            on { log(x = 1.0, eps = eps) } doReturn 0.0
        }
        val function = Function().apply {
            ln = lnMock
            log2 = log2Mock
            log3 = log3Mock
            log5 = log5Mock
            log10 = log10Mock
        }
        val x = 1.0
        val result = function.func(x, eps)
        assertTrue(result.isNaN())
    }

    @Test
    fun testTanNearPiOver2WithMocks() {
        val sinMock: Sin = mock{
            on {sin(x=Math.PI / 2, eps = eps)} doReturn 1.0
        }

        val cosMock: Cos = mock{
            on {cos(x=Math.PI / 2, eps = eps)} doReturn Double.NaN
        }
        val tan = Tan().apply {
            sin = sinMock
            cos = cosMock

        }
        val x = Math.PI / 2
        val result = tan.tan(x, eps)
        assertTrue(result.isNaN())
    }


    @Test
    fun testLnNegativeInputWithMocks() {
        val ln = Ln()
        val x = -1.0
        assertTrue(ln.ln(x, eps).isNaN())
    }

    @Test
    fun testLogNegativeInputWithMocks() {
        val log = Log(2.0)
        val x = -1.0
        assertTrue(log.log(x, eps).isNaN())
    }


    @Test
    fun testSinZeroWithMocks() {
        val sin = Sin()
        assertEquals(0.0, sin.sin(0.0, eps), eps)
    }

    @Test
    fun testCosZeroWithMocks() {
        val sinMock : Sin = mock {
            on { sin(x = Math.PI/4 + Math.PI/2, eps = eps) } doReturn 0.7071067812
        }
        val cos = Cos().apply {
            sin = sinMock
        }

        val result = cos.cos(Math.PI/4, eps)
        assertEquals(0.7071067812, result, eps)
    }

}
