fun main(){
    var fiboNumber = 100;

    var count = 0
    var n1 = 0
    var n2 = 1

    while (count < fiboNumber){
        println(n1)
        var sum = n1 + n2
        n1 = n2
        n2 = sum
        count += 1
    }
    }





