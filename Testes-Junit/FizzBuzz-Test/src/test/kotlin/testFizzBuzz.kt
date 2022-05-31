import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class testFizzBuzz {
    @Test
    fun fizzbuzz(){
        Assertions.assertEquals("fizzbuzz", FizzBuzz(30))
    }
    @Test
    fun fizz(){
        Assertions.assertEquals("fizz", FizzBuzz(3))
    }
    @Test
    fun buzz(){
        Assertions.assertEquals("buzz", FizzBuzz(5))
    }
    @Test
    fun returnNumber(){
        Assertions.assertEquals(4, FizzBuzz(4))
    }


}
