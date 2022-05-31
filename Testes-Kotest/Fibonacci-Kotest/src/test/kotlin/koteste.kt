import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec




class Kotest: FunSpec({

   test("testando fizzbuzz"){
       fibo().shouldBe("fizzbuzz")
    }

})


