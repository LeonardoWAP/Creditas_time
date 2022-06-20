package com.creditas.kotlinshell.shell


import com.creditas.kotlinshell.shell.example.Fibonacci
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class testFibo {
    @Test
    fun testfibonacci(){
        var numerosEsperads = mutableListOf(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89)
        Assertions.assertEquals(numerosEsperads,Fibonacci().fibo())
    }
}