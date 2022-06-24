package com.creditas.kotlinshell.shell.comands

import com.creditas.kotlinshell.shell.example.Account
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
    fun `When ContaBancariaCommand is called and the depositar is used, we have to return the deposit `(){
        //arrange
        val command = ContaBancariaCommand(account)

        //act
        command.depositar(5)

        //assert
        Mockito.verify(account).deposit(5)
    }

    @Test
    fun `When ContaBancariaCommand is called and the sacar is used, we have to return the saque`(){
        //arrange
        val command = ContaBancariaCommand(account)

        //act
        command.sacar(5)

        //assert
        Mockito.verify(account).saque(5)
    }

    @Test
    fun `When the ContaBancariaCommand is called, it returns the fizzbuzz return`(){
        //arrange
        val command = ContaBancariaCommand(account)

        //stub - trocar retorno
        Mockito.`when`(account.consulta_saldo()).thenReturn(2)

        //act
        val result = command.consulta()

        //assert
        TestCase.assertEquals(2, result)
    }


}

// AAA -  arrange act assert