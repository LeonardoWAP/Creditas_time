import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

class accounttest{

    @Test
    fun testDeposit(){
        val account = Account(100.00)
        account.deposit(10.00)
        assertEquals(110.00,account.saldo)

    }

    @Test
    fun testeSaque(){
        val account = Account(100.00)
        account.saque(10.00)
        assertEquals(90.00,account.saldo)

    }

    @Test
    fun testeTransfer(){
        val account = Account(100.00)
        val account2 = Account(10.00)
        account.transfer(account2,100.00)
        assertEquals(110.00,account2.saldo)
    }


}
