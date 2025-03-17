package itmo.tpo

class Log(private val n: Double) {
    private val ln: Ln = Ln()

    fun log(x: Double, eps: Double): Double {
        return ln.ln(x, eps) / ln.ln(n, eps)
    }
}