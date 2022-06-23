package com.creditas.kotlinshell.shell.example


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component


class Account (var saldo: Int){
    private val maxToDeposit: Int = 10000;

    private fun valueIsValid(value: Int): Boolean {
        if (value > saldo){
            return false
        }
        return true
    }

    fun consulta_saldo() : Int{
        return saldo
    }


    fun deposit(deposit: Int):Any{

        if(deposit < maxToDeposit){
            saldo += deposit
        } else {
            println("Deposito com Erro :Desculpe não podemos depositar valores acima de 10.000,00")
            return "erro"
        }
        return " "
    }


    fun saque(saque: Int):Int {
        if (valueIsValid(saque)){
            saldo -= saque
        } else{
            println("Saque com Erro: Desculpe seu saldo é menor que o saque")
        }
        return saldo
    }


    fun transfer(personTransfer: Account , transfer: Int){
        if (valueIsValid(transfer)){
            saque(transfer)
            personTransfer.deposit(transfer)
        }else{
            println("Transferencia com Erro! Desculpe seu saldo é menor que o saque")
        }
    }
}