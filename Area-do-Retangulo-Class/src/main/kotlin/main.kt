class Rectangle(width: Int, height: Int, color: String) {
    var width: Int = width;
    var height:Int = height;
    var color: String = color;
// metodo calcArea
    fun calcArea() : Int {
        return height  * width
    }
// metodo StringTo
    fun stringTo() : String {
        //receber um shape e retornar string com atributos.
        // função recebe rectangle e printa de acordo com o tamanho largura e area e cor
        return "width = ${width} height = ${height} color = ${color} Area =${calcArea()}"
    }
}

class Rectangle1(var width: Int, var height: Int ,var color : String){
// metodo é uma função dentro de uma classe - os objetos da classe podem realizar a ação dessa função
    fun calcArea() : Int {
        return height  * width
    }
    fun stringTo() : String {
        //receber um shape e retornar string com atributos.
        // função recebe rectangle e printa de acordo com o tamanho largura e area e cor
        return "width = ${width} height = ${height} color = ${color} Area =${calcArea()}"
    }
}


fun main() {
    val rectangle1 = Rectangle(color= "Red", width = 5, height = 5)
    // rectangle 1 é um objeto da classe que tem todos os metodos

    println(rectangle1.calcArea())
    //println(rectangle1.height)
    //println(rectangle1.width)
    //println(rectangle1.color)
    println(rectangle1.stringTo())


    val rectangle2 = Rectangle(color="green", width = 10 , height = 10)
    println(rectangle2.calcArea())
    //println(rectangle2.height)
    //println(rectangle2.width)
    //println(rectangle2.color)
    println(rectangle2.stringTo())

}








    //val rectangle = mutableMapOf("Width" to 10, "Height" to 15, "Color" to "Red")
//    print(calcArea(rectangle))

    // alteramos o valor do mutableMapOf



    // put para inserir um novo par de chaves
    // perguntar para valdir se era para ser declarada aqui ou no toString
//    rectangle.put ("Borda", 2)
//
//    println(rectangle)
//
//    println(calcArea2(rectangle))
//    println(toString(rectangle))
//
//    rectangle ["Width"] = 2
//    rectangle ["Height"] = 2
//    rectangle ["Color"] = "White"
//
//    println(toString(rectangle))
//    println(calcArea2(rectangle))
//



    // 1 - imprimir calculo da area de um triangulo - feito
    // 2 - imprimir toString de um retangulo - feito
    // 3 - Alterar um dos atributos e imprimir o ToString - feito
    // 4 - Alterar outro atributo e imprimir o toString




//

//
//

//




