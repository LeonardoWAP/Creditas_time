


import com.creditas.kotlinshell.shell.example.FizzBuzz
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class testFizzBuzz {
    @Test
    fun fizzbuzz() {

        Assertions.assertEquals("fizzbuzz", FizzBuzz().fizzbuzz(30))
    }
    @Test
    fun fizz(){
        Assertions.assertEquals("fizz", FizzBuzz().fizzbuzz(3))
    }
    @Test
    fun buzz(){
        Assertions.assertEquals("buzz", FizzBuzz().fizzbuzz(5))
    }
    @Test
    fun returnNumber(){
        Assertions.assertEquals(4, FizzBuzz().fizzbuzz(4))
    }


}
