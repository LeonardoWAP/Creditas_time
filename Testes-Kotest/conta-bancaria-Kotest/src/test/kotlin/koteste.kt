import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec

class kotest: FunSpec({
    test("testando Deposito"){
        val account = Account(100.00)
        account.deposit(10.00)
        account.saldo.shouldBe(110.00)
    }


    test("testando saque") {
        val account = Account(100.00)
        account.saque(10.00)
        account.saldo.shouldBe(90.00)
    }

    test("testando transfer") {
        val account = Account(100.00)
        val account2 = Account(100.00)
        account.transfer(account2,10.00)
        account2.saldo.shouldBe(110.00)
        account.saldo.shouldBe(90.00)
    }
})
