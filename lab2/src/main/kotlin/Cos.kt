package itmo.tpo

class Cos {
    private val sin: Sin = Sin()

    fun cos(x: Double, eps: Double): Double {
        return sin.sin(x + Math.PI / 2, eps)
    }
}