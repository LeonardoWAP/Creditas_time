package com.creditas.kotlinshell.shell.example

import org.springframework.shell.standard.ShellMethod
import org.springframework.shell.standard.ShellComponent
import org.springframework.stereotype.Component

@Component
class Calculadora {

    fun add(a: Int, b: Int): Int {
        return a + b
    }


    fun subtraction(a: Int, b: Int): Int {
        return a - b
    }


    fun multiplication(a: Int, b: Int): Int {
        return a * b
    }


    fun division(a: Int, b: Int): Int {
        return a / b
    }


}