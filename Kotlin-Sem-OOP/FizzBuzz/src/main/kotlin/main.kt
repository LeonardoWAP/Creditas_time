fun main(){
    var number = 30
    FizzBuzz(number)
}

fun FizzBuzz(number : Int){
    if (number % 3 == 0 && number % 5 == 0){
        println("fizzbuzz")
    }else if (number % 3 == 0 ){
        println("fizz")
    }else if (number% 5 == 0){
        println("buzz")
    }else{
        println(number)
    }
}



