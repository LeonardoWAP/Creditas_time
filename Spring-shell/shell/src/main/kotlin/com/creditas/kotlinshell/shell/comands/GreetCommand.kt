package com.creditas.kotlinshell.shell.comands

import com.creditas.kotlinshell.shell.example.*
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod


@ShellComponent
class GreetCommand (var a :A){
    @ShellMethod("A")
    fun greet() {
        a.greet()
    }
}