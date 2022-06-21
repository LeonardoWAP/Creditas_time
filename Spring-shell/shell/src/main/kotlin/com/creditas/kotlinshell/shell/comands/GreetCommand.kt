package com.creditas.kotlinshell.shell.comands

import com.creditas.kotlinshell.shell.example.*
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod


@ShellComponent
class GreetCommand {
    var h = H()
    var e = E()
    var g = G(e , h)
    var d = D(e)
    var c = C()
    var b = B(c , d)
    var f = F(g)
    var a = A(b , f)


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