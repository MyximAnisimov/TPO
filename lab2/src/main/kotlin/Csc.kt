package itmo.tpo

class Csc {
    private val sin: Sin = Sin()

    fun csc(x: Double, eps: Double): Double {
        return 1 / sin.sin(x, eps);
    }
}