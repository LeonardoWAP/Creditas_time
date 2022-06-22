package com.creditas.kotlinshell.shell.commands_examples

import com.creditas.kotlinshell.shell.comands.CalculatorCommand
import com.creditas.kotlinshell.shell.example.Calculadora
import junit.framework.TestCase.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

// References: https://www.baeldung.com/mockito-annotations
// Não esquecer da @RunWith na classe de teste
//
@RunWith(MockitoJUnitRunner::class)
class CalculatorCommandWithInjectMockTests {
    @BeforeEach
    fun init() {
        MockitoAnnotations.openMocks(this)
    }

    @Mock
    lateinit var calculadora: Calculadora

    @InjectMocks
    lateinit var command: CalculatorCommand

    @Test
    fun `(InjectMocks) When the sum command is called, it returns the calculator add return`() {
        Mockito.`when`(calculadora.add(1, 4)).thenReturn(100)

        assertEquals(100, command.sum(1, 4))
    }

    @Test
    fun `(InjectMocks) When the sum command is called, it calls the calculator add with the same numbers`() {
        command.sum(1, 4)

        Mockito.`verify`(calculadora).add(1, 4)
    }
}