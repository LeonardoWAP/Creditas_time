fun main(){
    var number = 5
    FizzBuzz(number)
}

fun FizzBuzz(number: Int):Any {
    if (number % 3 == 0 && number % 5 == 0){
        println("FizzBuzz")
        return "fizzbuzz"


    }else if (number % 3 == 0 ){
        println("fizz")
        return "fizz"
    }else if (number% 5 == 0){
        println("buzz")
        return "buzz"
    }else{
        println(number)
        return number
    }
    return number
}


