import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class SampleTest {
    @Test
    fun testSum(){
        val somando = OperandoNumeros(2.0,1.0)
        assertEquals(3.0 ,somando.sumNumbers())
    }

    @Test
    fun testSubstract(){
        val subtrai = OperandoNumeros (2.0,1.0).substractNumbers()
        assertEquals(1.0 , subtrai)
    }

    @Test
    fun testMultiplication(){
        val multiplica = OperandoNumeros(2.0,2.0).MultiplicationNumbers()
        assertEquals(4.0,multiplica)
    }
    @Test
    fun testdivision(){
        val divide = OperandoNumeros(10.0, 2.0).divisionNumber()
        assertEquals(5.0,divide)

    }

}