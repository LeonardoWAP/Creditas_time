package com.creditas.kotlinshell.shell.comands

import com.creditas.kotlinshell.shell.example.*
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod


@ShellComponent
class GreetCommand (var a :A,
                    var b :B,
                    var f :F
                    ){


    @ShellMethod("A")
    fun greeta() {
        a.greet()
    }

    @ShellMethod("B")
    fun greetb() {
        b.greet()
    }

    @ShellMethod("F")
    fun greetf() {
        f.greet()
    }
}