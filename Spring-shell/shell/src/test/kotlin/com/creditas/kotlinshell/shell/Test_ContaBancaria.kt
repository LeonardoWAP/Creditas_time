package com.creditas.kotlinshell.shell

import com.creditas.kotlinshell.shell.example.Account
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

class accounttest{

    @Test
    fun testDeposit(){
        val account = Account(100)
        account.deposit(10)
        assertEquals(110.00,account.saldo)

    }

    @Test
    fun testeSaque(){
        val account = Account(100)
        account.saque(10)
        assertEquals(90.00,account.saldo)

    }

    @Test
    fun testeTransfer(){
        val account = Account(100)
        val account2 = Account(10)
        account.transfer(account2,100)
        assertEquals(110.00,account2.saldo)
    }


}