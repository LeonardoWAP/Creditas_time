class OperandoNumeros(var n1: Double, var n2: Double){
    fun sumNumbers() : Double {
        return n1 + n2
    }

    fun substractNumbers() : Double{
        return n1 - n2
    }

}

fun main(){
    val somando = OperandoNumeros(2.0, 2.0)
    println(somando.sumNumbers())

}