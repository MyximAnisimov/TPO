package itmo.tpo

import itmo.tpo.functions.*

class Function {
    var tan: Tan = Tan()
    var sec: Sec = Sec()
    var csc: Csc = Csc()

    var ln: Ln = Ln()
    var log2: Log = Log(2.0)
    var log3: Log = Log(3.0)
    var log5: Log = Log(5.0)
    var log10: Log = Log(10.0)

    fun func(x: Double, eps: Double): Double {
        return if (x <= 0) {
            ((tan.tan(x, eps) / sec.sec(x, eps)) / csc.csc(x, eps)) * sec.sec(x, eps)
        } else {
            ((((log3.log(x, eps) / log5.log(x, eps)) + ln.ln(x, eps)) - log2.log(x, eps)) + log10.log(x, eps)) * ln.ln(x, eps)
        }
    }
}