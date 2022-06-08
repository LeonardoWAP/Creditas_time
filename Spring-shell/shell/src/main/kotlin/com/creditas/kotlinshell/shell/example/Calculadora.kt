package com.creditas.kotlinshell.shell.example

import org.springframework.shell.standard.ShellMethod
import org.springframework.shell.standard.ShellComponent

@ShellComponent
class Calculadora {
    @ShellMethod("Add two integers together.")
    fun add(a: Int, b: Int): Int {
        return a + b
    }

    @ShellMethod("Sub two integers together.")
    fun sub(a: Int, b: Int): Int {
        return a - b
    }

    @ShellMethod("mult two integers together.")
    fun mult(a: Int, b: Int): Int {
        return a * b
    }

    @ShellMethod("div two integers together.")
    fun div(a: Int, b: Int): Int {
        return a / b
    }


}