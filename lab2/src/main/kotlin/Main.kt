package itmo.tpo

fun main() {
    val sin = Sin()
    val cos = Cos()
    val tan = Tan()
    val sec = Sec()
    val csc = Csc()

    val ln = Ln()
    val log = Log(3.0)

    println("sin: ${sin.sin(10.0, 0.0000001)}")
    println("cos: ${cos.cos(10.0, 0.0000001)}")
    println("tan: ${tan.tan(10.0, 0.0000001)}")
    println("sec: ${sec.sec(10.0, 0.0000001)}")
    println("csc: ${csc.csc(10.0, 0.0000001)}")
    println("ln: ${ln.ln(10.0, 0.0000001)}")
    println("log3: ${log.log(10.0, 0.0000001)}")
}