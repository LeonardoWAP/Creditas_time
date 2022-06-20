package com.creditas.kotlinshell.shell.comands

import com.creditas.kotlinshell.shell.example.*
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

@ShellComponent
class CarCommand{

    @ShellMethod("motores")
    fun choosemotor(motor: Int ){
           val engine = if (motor == 1){
               val motorEletric = EletricEngine()
               val carEletric = Car(motorEletric)
               println("Motor Eletrico escolhido! \nPrecisa de extintor ${carEletric.useExtintor()}")
               println("Qualidade é nota ${carEletric.qualityGrade()}")
            } else if (motor == 2){
               println("\n\nmotor a gasolina")
               val motorGasoline = GasolineEngine()
               val carGasoline = Car(motorGasoline)
               println("precisa de extintor ${carGasoline.useExtintor()}")
               println("qualidade é nota ${carGasoline.qualityGrade()}")

           }else if(motor == 3){
               println("\n\nmotor a Hydrogenio")
               val motorHydrogen = HydrogenEngine()
               val carHydrogen = Car(motorHydrogen)
               println("precisa de extintor ${carHydrogen.useExtintor()}")
               println("qualidade é nota ${carHydrogen.qualityGrade()}")
           }else {
               println("\n\nmotor a Flex")
               val motorFlex = FlexEngine()
               val carFlex = Car(motorFlex)
               println("precisa de extintor ${carFlex.useExtintor()}")
               println("qualidade é nota ${carFlex.qualityGrade()}")
           }
        return engine
    }

}


