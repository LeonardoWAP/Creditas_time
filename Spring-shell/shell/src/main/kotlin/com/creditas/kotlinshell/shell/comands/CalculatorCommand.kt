package com.creditas.kotlinshell.shell.comands

import com.creditas.kotlinshell.shell.example.Calculadora
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod


@ShellComponent
class CalculatorCommand(val calculadora : Calculadora) {
    @ShellMethod("Add two integers together.")
    fun sum(a: Int, b: Int): Int{
        return calculadora.add(a, b)
    }

    @ShellMethod("Sub two integers together.")
    fun sub(a: Int, b: Int): Int{
        return calculadora.subtraction(a,b)
    }

    @ShellMethod("mult two integers together.")
    fun mult(a: Int, b: Int): Int{
        return calculadora.multiplication(a,b)
    }

    @ShellMethod("Div two integers together.")
    fun div(a: Int, b: Int): Int{
        return calculadora.division(a,b)
    }
}
