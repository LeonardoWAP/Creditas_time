package com.creditas.kotlinshell.shell.example

import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod


@ShellComponent
class FizzBuzz(){
    @ShellMethod("Testando Fizzbuzz")
    fun fizzbuzz(number: Int):Any {
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
}
