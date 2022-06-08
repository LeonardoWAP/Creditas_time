package com.creditas.kotlinshell.shell

import com.creditas.kotlinshell.shell.example.Calculadora
import com.creditas.kotlinshell.shell.example.FizzBuzz
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class testFizzBuzz {
    @Test
    fun fizzbuzz(){
        assertEquals("fizzbuzz", FizzBuzz(30))
    }
    @Test
    fun fizz(){
        assertEquals("fizz", FizzBuzz(3))
    }
    @Test
    fun buzz(){
        assertEquals("buzz", FizzBuzz(5))
    }
    @Test
    fun returnNumber(){
        assertEquals(4, FizzBuzz(4))
    }


}
