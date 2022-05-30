class Account (var saldo: Double ){
    private val maxToDeposit: Double = 10000.0;

    private fun valueIsValid(value: Double): Boolean {
        if (value > saldo){
            return false
            // retorna uma exception
        }
        return true
    }

//    fun valueSaldo():Double{
//        return saldo
//    }

    fun deposit(deposit: Double){
        //Deve possuir um método de depósito de dinheiro, mas só devem ser aceitos depósitos de no máximo R$ 10.000,00 (caso contrário, lança um erro)

        if(deposit < maxToDeposit){
            saldo += deposit
        } else {
            println("Deposito com Erro :Desculpe não podemos depositar valores acima de 10.000,00")
        }
    }

    fun saque(saque: Double){
        //Deve possuir um método de saque de dinheiro, mas durante essa operação o saldo da conta não pode ficar negativo (Caso contrário, lança um erro)
        if (valueIsValid(saque)){
            saldo -= saque
        } else{
            println("Saque com Erro: Desculpe seu saldo é menor que o saque")

        }
    }

    fun transfer(personTransfer: Account , transfer: Double){
        //Deve possuir um método de transferência de dinheiro, que recebe uma outra contaX (Instancia de Account) e o valor que deve ser transferido da conta atual para a contaX
        //A transferência deve seguir as regras de depósito e saque acima, inclusive com os casos de valores não aceitos
        //Não deve ser possível alterar o saldo da conta sem ser pelos métodos acima

        if (valueIsValid(transfer)){
            saque(transfer)
            personTransfer.deposit(transfer)
        }else{
            println("Transferencia com Erro! Desculpe seu saldo é menor que o saque")
        }
    }
    // faltou criar uma função de printar o saldo...

}

// Deve-se ter formas de se recuperar o valor do saldo da conta ???

fun main(){
//    // teste para deposito
//    println ("teste para deposito")
//    val account_Leonardo = Account(100.00)
//     println("leonardo Conta = " +account_Leonardo.saldo)
//    account_Leonardo.deposit(150.00)
//    println("Depositando conta leonardo")
//    println("leonardo Conta = " +account_Leonardo.saldo)
//    print("\n\n")

    //teste para saque
    println("teste para saque")
    val account_daiane = Account(100.00)
    println("daiane conta = " +account_daiane.saldo)
    println("SAQUE : daiane conta"+account_daiane.saque(190.00))
    println("daiane conta = " +account_daiane.saldo)

    print("\n\n")

//    account_daiane.transfer(account_Leonardo, 10.00)
//
//    println("leonardo Conta = " +account_Leonardo.saldo)
//    println("daiane conta = " +account_daiane.saldo)
//    Account_Leonardo.valueSaldo()

    // teste para transfer


}