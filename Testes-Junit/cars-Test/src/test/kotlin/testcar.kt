import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class testcar {
    @Test
    fun eletriccar(){
        val motorEletric = EletricEngine()
        val carEletric = Car(motorEletric)
        assertEquals(false,carEletric.useExtintor())
        assertEquals("A",carEletric.qualityGrade())
    }

    @Test
    fun CarGas(){
        val motorGas = GasEngine()
        val carGas = Car(motorGas)
        assertEquals(true,carGas.useExtintor())
        assertEquals("C",carGas.qualityGrade())
    }

    @Test
    fun CarGasoline(){
        val motorGasoline = GasolineEngine()
        val carGasoline = Car(motorGasoline)
        assertEquals(true,carGasoline.useExtintor())
        assertEquals("C",carGasoline.qualityGrade())
    }

    @Test
    fun CarHydrogenio(){
        val motorhidrogenio = HydrogenEngine()
        val carhidrogenio = Car(motorhidrogenio)
        assertEquals(false,carhidrogenio.useExtintor())
        assertEquals("A",carhidrogenio.qualityGrade())
    }

    @Test
    fun CarFlex(){
        val motorflex= FlexEngine()
        val carflex= Car(motorflex)
        assertEquals(true,carflex.useExtintor())
        assertEquals("B",carflex.qualityGrade())
    }

}
