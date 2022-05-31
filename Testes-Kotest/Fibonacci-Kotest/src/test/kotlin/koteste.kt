import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec




class Kotest: FunSpec({
    var numerosEsperads = mutableListOf(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89 , 144)
   test("testando fibo"){
       Fibonacci().shouldBe(numerosEsperads)
    }

})


