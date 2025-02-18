package itmo.tpo.sin
import kotlin.math.*

class Sin(val x: Double, val degree: Int) {

    fun decomposition(degree: Int, x: Double): Double{
        var result = 0.0;
        val acc = 1.0
        for(i in 1..degree){
            result += (((-1.0).pow(i.toDouble() - 1) * x.pow(2 * i.toDouble() - 1)) / factorial(acc, 2*i.toDouble() - 1))
        }
       return result
    }

    private fun factorial(counter: Double, number: Double) : Double{
        return if(number > 0){
            factorial(counter * number, number-1)
        }
        else{
            counter
        }
    }

}