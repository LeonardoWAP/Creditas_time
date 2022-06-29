package com.creditas.kotlinshell.shell.example

import org.springframework.stereotype.Component


@Component
class A(var b : B , var f : F ){
    fun greet(): String {
        b.greet()
        f.greet()
        println("I am A")
        return "I am A"
    }
}

@Component
class B(var c : C , var d : D ){
    fun greet(): String {
        c.greet()
        d.greet()
        println("I am B")
        return "I am B"
    }
}

@Component
class C(){
    fun greet(): String {
        println("I am C")
        return "I am C"
    }
}

@Component
class D(var e : E ){
    fun greet(): String {
        e.greet()
        println("I am D")
        return "I am D"
    }
}

@Component
class E(){
    fun greet(): String {
        println("I am E")
        return "I am E"
    }
}

@Component
class F(var g : G){
    fun greet(): String {
        g.greet()
        println("I am F")
        return "I am F"
    }
}


@Component
class G(var e : E , var h : H ){
    fun greet(): String {
        e.greet()
        h.greet()
        println("I am G")
        return "I am G"
    }
}
@Component
class H(){
    fun greet(): String {
        println("I am H")
        return "I am H"
    }
}




