package itmo.tpo.functions

open class Tan {
    private val sin: Sin = Sin()
    private val cos: Cos = Cos()

    open fun tan(x: Double, eps: Double): Double {
        return sin.sin(x, eps) / cos.cos(x, eps)
    }
}