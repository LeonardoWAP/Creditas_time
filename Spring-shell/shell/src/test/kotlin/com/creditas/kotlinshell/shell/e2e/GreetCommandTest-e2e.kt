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
class `GreetCommandTest-e2e` {
        @Autowired
        private lateinit var shell: Shell

        @Test
        fun `When calling the "greet" it returns Strings according to the tree`() {
            val output = shell.evaluate { "greet" }

            TestCase.assertEquals(" ", output)
        }

}