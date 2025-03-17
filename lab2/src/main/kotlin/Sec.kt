package itmo.tpo

class Sec {
    private val cos: Cos = Cos()

    fun sec(x: Double, eps: Double): Double {
        return 1 / cos.cos(x, eps)
    }
}