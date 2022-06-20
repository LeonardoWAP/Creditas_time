package com.creditas.kotlinshell.shell.comands

import com.creditas.kotlinshell.shell.example.FizzBuzz
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

@ShellComponent
class FizzbuzzCommand(val fizz_buzz : FizzBuzz) {
    @ShellMethod("fizzbuzz")
    fun fizzbuzz(number: Int):Any{
        return fizz_buzz.fizzbuzz(number)
    }
}