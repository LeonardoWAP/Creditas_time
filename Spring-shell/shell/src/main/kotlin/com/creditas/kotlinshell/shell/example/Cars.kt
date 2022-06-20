package com.creditas.kotlinshell.shell.example

import org.springframework.stereotype.Component



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

@Component
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

@Component
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

@Component
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

@Component
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

@Component
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
