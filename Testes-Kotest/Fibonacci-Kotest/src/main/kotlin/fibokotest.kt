fun fibo(){
    var fiboNumber = 100;
    var n1 = 0
    var n2 = 1


    while (n1 < fiboNumber){

        var sum = n1 + n2
        n1 = n2
        n2 = sum
        println(n1)
    }
}

fun main(){
    fibo()
}



