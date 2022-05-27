import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec


class kotest: FunSpec({
    val calculadora = Calculadora()
   test("testando Soma"){
        calculadora.soma(10.0, 20.0).shouldBe(30.0)
        calculadora.soma(20.0, 20.0).shouldBe(40.0)
        calculadora.soma(50.0, 40.0).shouldBe(90.0)
    }


  test("testando sub") {
        calculadora.subtração(10.0, 20.0).shouldBe(-10.0)
        calculadora.subtração(20.0, 20.0).shouldBe(0.0)
        calculadora.subtração(30.0, 10.0).shouldBe(20.0)
    }

    test("testano mult"){
        calculadora.multiplicação(2.0, 5.0).shouldBe(10.0)
        calculadora.multiplicação(5.0, 5.0).shouldBe(25.0)
        calculadora.multiplicação(10.0, 7.0).shouldBe(70.0)
    }

    test("testando div") {
        calculadora.divisão(10.0, 2.0).shouldBe(5.0)
        calculadora.divisão(30.0, 3.0).shouldBe(10.0)
        calculadora.divisão(60.0, 5.0).shouldBe(12.0)
    }
})


