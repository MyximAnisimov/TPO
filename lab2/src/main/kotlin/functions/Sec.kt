package itmo.tpo.functions

open class Sec {
    var cos: Cos = Cos()

    open fun sec(x: Double, eps: Double): Double {
        return if(x == 1.0){
            Double.NaN;
        }
        else{
            1 / cos.cos(x, eps)
        }
    }
}