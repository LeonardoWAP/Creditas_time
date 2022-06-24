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

class CalculatorCommandWithFakeClassTests {

    class FakeCalculator(): Calculadora() {
        var fakeReturn: Int = 0

        val calledValues: MutableList<List<Int>> = mutableListOf()

        override fun add(a: Int, b: Int): Int {
            calledValues.add(listOf(a, b))

            return fakeReturn
        }
    }

    private val fakeCalculator = FakeCalculator()

    @Test
    fun `When the sum command is called, it returns the calculator add return`() {
        val command = CalculatorCommand(fakeCalculator)

        fakeCalculator.fakeReturn = 5

        assertEquals(5, command.sum(1, 9))
    }

    @Test
    fun `When the sum command is called, it calls the calculator add with the same numbers`() {
        // ???
    }
}