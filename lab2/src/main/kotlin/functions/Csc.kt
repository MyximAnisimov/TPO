package itmo.tpo.functions

open class Csc {
    private val sin: Sin = Sin()

    open fun csc(x: Double, eps: Double): Double {
        return 1 / sin.sin(x, eps);
    }
}