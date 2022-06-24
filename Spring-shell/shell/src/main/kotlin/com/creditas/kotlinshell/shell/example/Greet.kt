package com.creditas.kotlinshell.shell.example

import org.springframework.stereotype.Component


@Component
class A(var b : B , var f : F ){
    fun greet(){
        println("I am A")
        b.greet()
        f.greet()
    }
}

@Component
class B(var c : C , var d : D ){
    fun greet(){
        println("I am B")
        c.greet()
        d.greet()
    }
}

@Component
class C(){
    fun greet(){
        println("I am C")
    }
}

@Component
class D(var e : E ){
    fun greet(){
        println("I am D")
        e.greet()
    }
}

@Component
class E(){
    fun greet(){
        println("I am E")
    }
}

@Component
class F(var g : G){
    fun greet(){
        println("I am F")
        g.greet()
    }
}


@Component
class G(var e : E , var h : H ){
    fun greet(){
        println("I am G")
        e.greet()
        h.greet()
    }
}
@Component
class H(){
    fun greet(){
        println("I am H")
    }
}




