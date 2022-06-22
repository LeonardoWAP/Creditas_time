package com.creditas.kotlinshell.shell

import com.creditas.kotlinshell.shell.example.Calculadora
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class TesteCalculadora {
    @Test
    fun add(){
        val somando = Calculadora()
        assertEquals(3 ,somando.add(2,1))
    }

//    @Test
//    fun sub(){
//        val subtrai = Calculadora ()
//        assertEquals(1 ,subtrai.sub(2,1))
//    }
//
//    @Test
//    fun mult(){
//        val multiplica = Calculadora()
//        assertEquals(10,multiplica.mult(2,5))
//    }
//    @Test
//    fun div(){
//        val divisao = Calculadora()
//        assertEquals(5,divisao.div(10,2))
//    }

}

