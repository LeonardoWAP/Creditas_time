package com.creditas.kotlinshell.shell.e2e

import com.creditas.kotlinshell.shell.comands.ContaBancariaCommand
import com.creditas.kotlinshell.shell.example.Account
import junit.framework.TestCase
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.shell.Shell
import org.springframework.shell.jline.InteractiveShellApplicationRunner
import org.springframework.shell.jline.ScriptShellApplicationRunner


@SpringBootTest(properties = [
    InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
    ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT + ".enabled=false"
])
class `ContaBancariaCommandTest-e2e` {


        @Autowired
        private lateinit var shell: Shell

        @Test
        fun `When calling the "consulta" it returns int with the value of account 0`() {
            val output = shell.evaluate { "consulta" }

            TestCase.assertEquals(0, output)
        }

        @Test
        fun `When calling the "sacar" it returns int with the value of account 0`() {
            shell.evaluate { "depositar 10" }
            shell.evaluate { "sacar 10" }

            TestCase.assertEquals(0, shell.evaluate { "consulta" })
        }

        @Test
        fun `When calling the "Depositar" it returns int with the value of account `() {
            shell.evaluate { "depositar 0" }

            TestCase.assertEquals(0, shell.evaluate { "consulta" })
        }
    }
