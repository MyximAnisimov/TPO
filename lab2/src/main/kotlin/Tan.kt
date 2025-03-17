package itmo.tpo

class Tan {
    private val sin: Sin = Sin()
    private val cos: Cos = Cos()

    fun tan(x: Double, eps: Double): Double {
        return sin.sin(x, eps) / cos.cos(x, eps)
    }
}