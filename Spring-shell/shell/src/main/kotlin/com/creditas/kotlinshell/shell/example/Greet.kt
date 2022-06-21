package com.creditas.kotlinshell.shell.example



class A(var b : B , var f : F ){
    fun greet(){
        println("I am A")
        b.greet()
        f.greet()
    }
}

class B(var c : C , var d : D ){
    fun greet(){
        println("I am B")
        c.greet()
        d.greet()
    }
}

class C(){
    fun greet(){
        println("I am C")
    }
}

class D(var e : E ){
    fun greet(){
        println("I am D")
        e.greet()
    }
}

class E(){
    fun greet(){
        println("I am E")
    }
}

class F(var g : G){
    fun greet(){
        println("I am F")
        g.greet()
    }
}


class G(var e : E , var h : H ){
    fun greet(){
        println("I am G")
        e.greet()
        h.greet()
    }
}

class H(){
    fun greet(){
        println("I am H")
    }
}




