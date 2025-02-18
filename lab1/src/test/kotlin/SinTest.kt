import itmo.tpo.sin.Sin
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.assertEquals

class SinTest {

    @ParameterizedTest
    @ValueSource(doubles = [1.0, 2.0, 3.0, 4.0])
    fun `must calculate correctly`(param: Double) {
        val sin = Sin(param, 100)
       assertEquals(Math.sin(param), sin.decomposition(sin.degree, sin.x), 0.00000001)
    }
}