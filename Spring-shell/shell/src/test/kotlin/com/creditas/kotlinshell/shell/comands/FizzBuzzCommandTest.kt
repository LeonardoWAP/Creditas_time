package com.creditas.kotlinshell.shell.comands

import com.creditas.kotlinshell.shell.example.FizzBuzz
import junit.framework.TestCase
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class FizzBuzzCommandTest {
    @BeforeEach
    fun init() {
        MockitoAnnotations.openMocks(this)
    }

    @Mock
    lateinit var fizz_buzz: FizzBuzz

    @Test
    fun `(Mock) When the FizzBuzz command is called, it returns the fizzbuzz return`(){
        //arrange
        val command = FizzbuzzCommand(fizz_buzz)

        //stub - trocar retorno
        Mockito.`when`(fizz_buzz.fizzbuzz(2)).thenReturn("fdd")

        //act
        val result = command.fizzbuzz(2)

        //assert
        TestCase.assertEquals("fdd", result)

        //spy - verifica se o metodo foi chamado com o parametro , no caso 2 .
        Mockito.`verify`(fizz_buzz).fizzbuzz(2)

    }
}