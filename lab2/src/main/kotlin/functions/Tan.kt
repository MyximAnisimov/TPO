package itmo.tpo.functions

open class Tan {
    var sin: Sin = Sin()
    var cos: Cos = Cos()

    open fun tan(x: Double, eps: Double): Double {
        return sin.sin(x, eps) / cos.cos(x, eps)
    }
}