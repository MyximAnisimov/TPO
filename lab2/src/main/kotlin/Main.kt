package itmo.tpo

import java.io.File
import java.io.FileWriter

fun writeToCSV(x: List<Double>, eps: Double, filename: String, func: (Double, Double) -> Double) {
    val file = File(filename)
    FileWriter(file).use { writer ->
        if (file.length() == 0L) {
            writer.append("X,Результат модуля (X)\n")
        }
        x.forEach { writer.append("$it,${func(it, eps)}\n") }
    }
}

fun main() {
    val sin = Sin()
    val cos = Cos()
    val tan = Tan()
    val sec = Sec()
    val csc = Csc()

    val ln = Ln()
    val log = Log(3.0)
    val func = Function()

    println("sin: ${sin.sin(10.0, 0.0000001)}")
    println("cos: ${cos.cos(10.0, 0.0000001)}")
    println("tan: ${tan.tan(10.0, 0.0000001)}")
    println("sec: ${sec.sec(10.0, 0.0000001)}")
    println("csc: ${csc.csc(10.0, 0.0000001)}")
    println("ln: ${ln.ln(10.0, 0.0000001)}")
    println("log3: ${log.log(10.0, 0.0000001)}")
    println("func 10: ${func.func(1.1, 0.0000001)}")
    println("func -10: ${func.func(0.0, 0.0000001)}")

    val funcTestValues: List<Double> = listOf(-5.0, -4.0, -3.0, -2.0, -1.0, 0.0, 1.0, 2.0, 3.0, 4.0, 5.0)
    writeToCSV(funcTestValues, 0.00001, "src/main/resources/FuncTest.csv", func::func)
    writeToCSV(funcTestValues, 0.00001, "src/main/resources/TanTest.csv", sin::sin)
}