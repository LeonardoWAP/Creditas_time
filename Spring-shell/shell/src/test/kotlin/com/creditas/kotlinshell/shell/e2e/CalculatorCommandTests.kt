package com.creditas.kotlinshell.shell.e2e

import junit.framework.TestCase.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.shell.Shell
import org.springframework.shell.jline.InteractiveShellApplicationRunner
import org.springframework.shell.jline.ScriptShellApplicationRunner


@SpringBootTest(properties = [
    InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
    ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT + ".enabled=false"
])
class CalculatorCommandTests {
    @Autowired
    private lateinit var shell: Shell

    @Test
    fun `When calling the "sum" with two numbers, it returns the sum of both numbers`() {
        val output = shell.evaluate { "sum 1 2" }

        assertEquals(3, output)
    }

    @Test
    fun `When calling the "sub" with two numbers, it returns the subtraction of first by the second`() {
        val output = shell.evaluate { "sub 5 1" }

        assertEquals(4, output)
    }

    @Test
    fun `When calling the "mult" with two numbers, it returns the multiplication of first by the second`() {
        val output = shell.evaluate { "mult 5 1" }

        assertEquals(5, output)
    }

    @Test
    fun `When calling the "div" with two numbers, it returns the division of first by the second`() {
        val output = shell.evaluate { "div 10 2" }

        assertEquals(5, output)
    }


}