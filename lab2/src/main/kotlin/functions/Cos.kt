package itmo.tpo.functions

open class Cos {
    var sin: Sin = Sin()

    open fun cos(x: Double, eps: Double): Double {
        return sin.sin(x + Math.PI / 2, eps)
    }
}