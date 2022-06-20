package com.creditas.kotlinshell.shell.example

import org.springframework.shell.standard.ShellMethod
import org.springframework.stereotype.Component


@Component
class FizzBuzz{
    fun fizzbuzz(number: Int):Any {
        if (number % 3 == 0 && number % 5 == 0){
            return "fizzbuzz"
        }else if (number % 3 == 0 ){
            return "fizz"
        }else if (number% 5 == 0){
            return "buzz"
        }else{
            println(number)
            return number
        }

    }
}
