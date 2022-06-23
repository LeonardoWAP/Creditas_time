package com.creditas.kotlinshell.shell.comands

import com.creditas.kotlinshell.shell.example.Calculadora
import junit.framework.TestCase
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CalculatorCommandTest {

    @BeforeEach
    fun init() {
        MockitoAnnotations.openMocks(this)
    }

    @Mock
    lateinit var calculadora: Calculadora

    @Test
    fun `(Mock) When the sum command is called, it returns the calculator add return`() {
        val command = CalculatorCommand(calculadora)

        Mockito.`when`(calculadora.add(1, 4)).thenReturn(100)

        TestCase.assertEquals(100, command.sum(1, 4))
    }

    @Test
    fun `(Mock) When the sum command is called, it calls the calculator add with the same numbers`() {
        val command = CalculatorCommand(calculadora)

        command.sum(1, 4)

        Mockito.`verify`(calculadora).add(1, 4)
    }

    @Test
    fun `(Mock) When the sub command is called, it calls the calculator subtraction with the same numbers`() {
        val command = CalculatorCommand(calculadora)

        command.sub(1, 4)

        Mockito.`verify`(calculadora).subtraction(1, 4)
    }

    @Test
    fun `(Mock) When the mult command is called, it calls the calculator multiplication with the same numbers`() {
        val command = CalculatorCommand(calculadora)

        command.mult(1, 4)

        Mockito.`verify`(calculadora).multiplication(1, 4)
    }
}