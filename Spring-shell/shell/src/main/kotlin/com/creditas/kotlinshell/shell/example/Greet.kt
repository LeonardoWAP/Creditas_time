package com.creditas.kotlinshell.shell.example

import org.springframework.stereotype.Component


@Component
class A(var b : B , var f : F ){
    fun greet(): String {
        b.greet()
        f.greet()
        return "I am A"
    }
}

@Component
class B(var c : C , var d : D ){
    fun greet(): String {
        c.greet()
        d.greet()
        return "I am B"
    }
}

@Component
class C(){
    fun greet(): String {
        return "I am C"
    }
}

@Component
class D(var e : E ){
    fun greet(): String {
        e.greet()
        return "I am D"
    }
}

@Component
class E(){
    fun greet(): String {
        return "I am E"
    }
}

@Component
class F(var g : G){
    fun greet(): String {
        g.greet()
        return "I am F"
    }
}


@Component
class G(var e : E , var h : H ){
    fun greet(): String {
        e.greet()
        h.greet()
        return "I am G"
    }
}
@Component
class H(){
    fun greet(): String {
        return "I am H"
    }
}




