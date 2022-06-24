package com.creditas.kotlinshell.shell

import com.creditas.kotlinshell.shell.example.Account
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

class accounttest{
    @Test
    fun testDeposit(){
        val account = Account()
        account.deposit(10)
        assertEquals(10,account.consulta_saldo())

    }

    @Test
    fun testeSaque(){
        val account = Account()
        account.deposit(100)
        account.saque(10)
        assertEquals(90,account.consulta_saldo())
    }

    @Test
    fun testeTransfer(){
        val account = Account()
        val account2 = Account()
        account.deposit(100)
        account.transfer(account2,100)
        assertEquals(100,account2.consulta_saldo())
    }
}