package com.creditas.kotlinshell.shell.example
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

@ShellComponent
class Fibonacci(){
    fun fibo(): MutableList<Int> {
        var fiboNumber = 100
        var n1 = 0
        var n2 = 1
        var fibonaNumber = mutableListOf<Int>()



        while (n1 < fiboNumber){

            var sum = n1 + n2
            n1 = n2
            n2 = sum
            fibonaNumber.add(n1)

        }

        return fibonaNumber
    }
}
