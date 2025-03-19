package itmo.tpo

import java.io.File
import java.io.FileWriter

class Function {
    private val tan: Tan = Tan()
    private val sec: Sec = Sec()
    private val csc: Csc = Csc()

    private val ln: Ln = Ln()
    private val log2: Log = Log(2.0)
    private val log3: Log = Log(3.0)
    private val log5: Log = Log(5.0)
    private val log10: Log = Log(10.0)

    fun func(x: Double, eps: Double): Double {
        return if (x <= 0) {
            ((tan.tan(x, eps) / sec.sec(x, eps)) / csc.csc(x, eps)) * sec.sec(x, eps)
        } else {
            ((((log3.log(x, eps) / log5.log(x, eps)) + ln.ln(x, eps)) - log2.log(x, eps)) + log10.log(x, eps)) * ln.ln(x, eps)
        }
    }
}