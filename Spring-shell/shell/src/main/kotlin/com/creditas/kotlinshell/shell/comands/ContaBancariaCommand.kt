package com.creditas.kotlinshell.shell.comands

import com.creditas.kotlinshell.shell.example.Account
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

@ShellComponent
class ContaBancariaCommand (val ohira_account: Account = Account(0)){
//    val ohira_account = Account(0)

    @ShellMethod("consulta")
    fun consulta(): Int{
        return ohira_account.consulta_saldo()
    }

    @ShellMethod("sacar")
    fun sacar(valor :Int){
        ohira_account.saque(valor)
    }

    @ShellMethod("Depositar")
    fun depositar(valor :Int){
        ohira_account.deposit(valor)
    }
}