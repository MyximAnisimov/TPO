import itmo.tpo.sin.Sin
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.sin
import kotlin.test.assertEquals

class SinTest {

    @ParameterizedTest
    @ValueSource(doubles = [0.0, Math.PI, 0.00001, 1e-6, -1e-6, Math.PI/6, Math.PI/4, Math.PI/2, -Math.PI/6, -Math.PI/4, -Math.PI/2, 10.0, -242.0])
    fun `must calculate correctly`(param: Double) {
        val sin = Sin(BigDecimal(param), 5000)
        assertEquals(BigDecimal(sin(param)).setScale(13, RoundingMode.UP), sin.decomposition(sin.x, sin.degree).setScale(13, RoundingMode.UP))
    }
}