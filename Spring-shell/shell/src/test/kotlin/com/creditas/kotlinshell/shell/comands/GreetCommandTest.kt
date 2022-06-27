package com.creditas.kotlinshell.shell.comands

import com.creditas.kotlinshell.shell.example.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GreetCommandTest {
    @BeforeEach
    fun init() {
        MockitoAnnotations.openMocks(this)
    }

    //@MockBean
    @Mock
    lateinit var a : A


    // oque preciso verificar em GreetCommand
    // preciso verificar se os parametros estão chegando
    // para testar A preciso criar um fake de B e F ?
    //

    // uma das ideias para testar é verificar todas as classes quantas vezes elas rodam
    // todas tem que rodar 1 vez só a classe E que rodaria 2 x

    @Test
    fun `When the GreetCommand is called, it calls the greet with the orthers class`() {
        val command = GreetCommand(a)

        command.greet()

        // verifico quantas vezes a classe A foi chamada
        Mockito.verify(a, Mockito.times(1)).greet()
    }
}