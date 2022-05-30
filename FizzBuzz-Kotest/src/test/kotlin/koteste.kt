import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec




class Kotest: FunSpec({

   test("testando fizzbuzz"){
       FizzBuzz(30).shouldBe("fizzbuzz")
    }

    test("testando fizz"){
        FizzBuzz(3).shouldBe("fizz")
    }

    test("testando buzz"){
        FizzBuzz(5).shouldBe("buzz")
    }

    test("testando return"){
        FizzBuzz(4).shouldBe(4)
    }
})


