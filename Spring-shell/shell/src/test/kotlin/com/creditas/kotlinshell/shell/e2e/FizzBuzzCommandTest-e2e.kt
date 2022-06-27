package com.creditas.kotlinshell.shell.e2e

import junit.framework.TestCase
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
class `FizzBuzzCommandTest-e2e` {
        @Autowired
        private lateinit var shell: Shell

        @Test
        fun `When calling the "fizzbuzz" with one number = 30 , it returns String "fizzbuzz"`() {
            val output = shell.evaluate { "fizzbuzz 30" }

            TestCase.assertEquals("fizzbuzz", output)
        }

        @Test
        fun `When calling the "fizzbuzz" with one number = 3 , it returns String "fizz"`() {
            val output = shell.evaluate { "fizzbuzz 3" }

            TestCase.assertEquals("fizz", output)
        }

        @Test
        fun `When calling the "fizzbuzz" with one number = 5 , it returns String "buzz"`() {
            val output = shell.evaluate { "fizzbuzz 5" }

            TestCase.assertEquals("buzz", output)
        }
}