class Car (var motor : Motor ){
    fun qualityGrade() : String{
        if  (motor.isEnvironmentalFriendly() && !motor.useFossilFuel()){
            return ("A")
        }
        else if (motor.isEnvironmentalFriendly() && motor.useFossilFuel()){
            return ("B")
        }
        else if (!motor.isEnvironmentalFriendly()){
            return ("C")
        }
        return ("ERRO")
    }

    fun useExtintor(): Boolean{
        if (motor.useFlammableFuel()){
            return true;
        }
        return false
    }
}
interface Motor {
    fun isEnvironmentalFriendly(): Boolean;
    fun useFlammableFuel(): Boolean;
    fun useFossilFuel(): Boolean;
}

class EletricEngine () :Motor{

    override fun isEnvironmentalFriendly():Boolean {
        return true;
    }

    override fun useFlammableFuel():Boolean {
        return false;
    }

    override fun useFossilFuel():Boolean {
        return false;
    }
}

class GasEngine ():Motor{
    override fun isEnvironmentalFriendly():Boolean {
        return false;
    }

    override fun useFlammableFuel():Boolean {
        return true;
    }

    override fun useFossilFuel():Boolean {
        return false;
    }
}

class GasolineEngine ():Motor{
    override fun isEnvironmentalFriendly():Boolean {
        return false;
    }
    override fun useFlammableFuel():Boolean {
        return true;
    }

    override fun useFossilFuel():Boolean {
        return true;
    }
}

class HydrogenEngine():Motor{
    override fun isEnvironmentalFriendly():Boolean {
        return true;
    }
    override fun useFlammableFuel():Boolean {
        return false;
    }

    override fun useFossilFuel():Boolean {
        return false;
    }
}

class FlexEngine():Motor{
    override fun isEnvironmentalFriendly():Boolean {
        return true;
    }
    override fun useFlammableFuel():Boolean {
        return true;
    }

    override fun useFossilFuel():Boolean {
        return true;
    }
}

fun main(){
    println("motor eletrico")
    val motorEletric = EletricEngine()
    val carEletric = Car(motorEletric)
    println("precisa de extintor ${carEletric.useExtintor()}")
    println("qualidade é nota ${carEletric.qualityGrade()}")

    println("\n\nmotor a gas")
    val motorGas = GasEngine()
    val carGas = Car(motorGas)
    println("precisa de extintor ${carGas.useExtintor()}")
    println("qualidade é nota ${carGas.qualityGrade()}")

    println("\n\nmotor a gasolina")
    val motorGasoline = GasolineEngine()
    val carGasoline = Car(motorGasoline)
    println("precisa de extintor ${carGasoline.useExtintor()}")
    println("qualidade é nota ${carGasoline.qualityGrade()}")

    println("\n\nmotor a Hydrogenio")
    val motorHydrogen = HydrogenEngine()
    val carHydrogen = Car(motorHydrogen)
    println("precisa de extintor ${carHydrogen.useExtintor()}")
    println("qualidade é nota ${carHydrogen.qualityGrade()}")

    println("\n\nmotor a Flex")
    val motorFlex = FlexEngine()
    val carFlex = Car(motorFlex)
    println("precisa de extintor ${carFlex.useExtintor()}")
    println("qualidade é nota ${carFlex.qualityGrade()}")

}
