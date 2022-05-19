open class Animal (){
    open fun walkEarth():Boolean{
        return true
        // animal pode voar tbm
    }

    open fun liveWater():Boolean{
        return true
        // animal pode viver na agua
    }

    open fun fly():Boolean{
        return true
        // animal pode voar
    }

    open fun isAlive():Boolean{
        return true
    }

    open fun layEgg():Boolean{
        return true
        // existem animais que botao ovo
    }

}
class Snake : Animal(){
    override fun liveWater(): Boolean {
        return false
    }

    override fun fly(): Boolean {
        return false
    }


}
class Hawk () :Animal(){
    override fun walkEarth(): Boolean {
        return false
    }

    override fun liveWater(): Boolean {
        return false
    }


}
class Bird ():Animal(){
    override fun walkEarth(): Boolean {
        return false
    }

    override fun liveWater(): Boolean {
        return false
    }
}



open class Mammal (){

    open fun walkEarth():Boolean{
        return true

    }

    open fun liveWater():Boolean{
        return true

    }

    open fun fly():Boolean{
        return false

    }

    open fun isAlive():Boolean{
        return true
    }

    open fun layEgg():Boolean{
        return false

    }

}
class Human ():Mammal(){
    override fun liveWater(): Boolean {
        return false
    }



}
class Dog ():Mammal(){
    override fun liveWater(): Boolean {
        return false
    }


}
class Whale ():Mammal(){
    override fun walkEarth(): Boolean {
        return false
    }

}
class Einstein ():Mammal(){
    override fun liveWater(): Boolean {
        return false
    }

    override fun isAlive(): Boolean {
        return false
    }
}

class Penguim():Animal(){
    override fun fly(): Boolean {
        return false
    }


}
class Bat():Animal(){
    override fun liveWater(): Boolean {
        return false
    }
    override fun walkEarth(): Boolean {
        return false
    }

}










fun main(){
    val cobra = Snake()
    println("cobra")
    println("anda na terra = " + cobra.walkEarth())
    println("vive na agua = " +cobra.liveWater())
    println("sabe voar = " +cobra.fly())
    println("está viva = "+ cobra.isAlive())
    println("bota ovo = "+ cobra.layEgg())

    val aguia = Hawk()
    println("Aguia")
    println("anda na terra = " + aguia.walkEarth())
    println("vive na agua = " +aguia.liveWater())
    println("sabe voar = " +aguia.fly())
    println("está viva = "+ aguia.isAlive())
    println("bota ovo = "+ aguia.layEgg())

      val passarinho = Bird()
      println("passarinho")
      println("anda na terra = " + passarinho.walkEarth())
      println("vive na agua = " +passarinho.liveWater())
      println("sabe voar = " +passarinho.fly())
      println("está viva = "+ passarinho.isAlive())
      println("bota ovo = "+ passarinho.layEgg())

    val humano = Human()
    println("humano")
    println("anda na terra = " + humano.walkEarth())
    println("vive na agua = " +humano.liveWater())
    println("sabe voar = " +humano.fly())
    println("está viva = "+ humano.isAlive())
    println("bota ovo = "+ humano.layEgg())

    val cachorro = Dog()
    println("humano")
    println("anda na terra = " + cachorro.walkEarth())
    println("vive na agua = " +cachorro.liveWater())
    println("sabe voar = " +cachorro.fly())
    println("está viva = "+ cachorro.isAlive())
    println("bota ovo = "+ cachorro.layEgg())

    val baleia = Whale()
    println("baleia")
    println("anda na terra = " + baleia.walkEarth())
    println("vive na agua = " +baleia.liveWater())
    println("sabe voar = " +baleia.fly())
    println("está viva = "+ baleia.isAlive())
    println("bota ovo = "+ baleia.layEgg())

    val einstein = Einstein()
    println("baleia")
    println("anda na terra = " + einstein.walkEarth())
    println("vive na agua = " +einstein.liveWater())
    println("sabe voar = " +einstein.fly())
    println("está viva = "+ einstein.isAlive())
    println("bota ovo = "+ einstein.layEgg())

      val peguim = Penguim()
      println("penguim")
      println("anda na terra = " + peguim.walkEarth())
      println("vive na agua = " +peguim.liveWater())
      println("sabe voar = " +peguim.fly())
      println("está viva = "+ peguim.isAlive())
      println("bota ovo = "+ peguim.layEgg())

      val bat = Bat()
      println("bat")
      println("anda na terra = " + bat.walkEarth())
      println("vive na agua = " +bat.liveWater())
      println("sabe voar = " +bat.fly())
      println("está viva = "+ bat.isAlive())
      println("bota ovo = "+ bat.layEgg())



}