package itmo.tpo.functions

open class Cos {
    private val sin: Sin = Sin()

    open fun cos(x: Double, eps: Double): Double {
        return sin.sin(x + Math.PI / 2, eps)
    }
}