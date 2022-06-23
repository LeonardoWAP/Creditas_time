package com.creditas.kotlinshell.shell.comands

import com.creditas.kotlinshell.shell.example.Account
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
class ContaBancariaCommandTest {
    @BeforeEach
    fun init() {
        MockitoAnnotations.openMocks(this)
    }

    @Mock
    lateinit var account: Account

    @Test
    fun `(Mock) When the ContaBancariaCommand is called, it returns the account saque return`(){
        //arrange
        val command = ContaBancariaCommand(account)
        Mockito.`when`(account.saque(5)).thenReturn(0)

        //act
        val result = command.sacar(5)

        //assert
        TestCase.assertEquals(0, result)
    }
}

// AAA -  arrange act assert