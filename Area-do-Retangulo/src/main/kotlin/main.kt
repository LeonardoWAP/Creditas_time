fun main(){
    val rectangle = mutableMapOf("Width" to 10, "Height" to 15, "Color" to "Red")
//    print(calcArea(rectangle))

    // alteramos o valor do mutableMapOf



    // put para inserir um novo par de chaves
    // perguntar para valdir se era para ser declarada aqui ou no toString
    rectangle.put ("Borda", 2)

    println(rectangle)

    println(calcArea2(rectangle))
    println(toString(rectangle))

    rectangle ["Width"] = 2
    rectangle ["Height"] = 2
    rectangle ["Color"] = "White"

    println(toString(rectangle))
    println(calcArea2(rectangle))




    // 1 - imprimir calculo da area de um triangulo - feito
    // 2 - imprimir toString de um retangulo - feito
    // 3 - Alterar um dos atributos e imprimir o ToString - feito
    // 4 - Alterar outro atributo e imprimir o toString
}


fun toString(shape : Map<String, Any>) : String {
    //receber um shape e retornar string com atributos.
    // função recebe rectangle e printa de acordo com o tamanho largura e area e cor
    return "Width = ${shape["Width"]} Height = ${shape["Height"]}  color = ${shape["Color"]} Area = ${calcArea2(shape)}"
}


fun calcArea(shape : Map<String, Any>) : Int {
    // receber shape , e retornar a area do triangulo
    // area do retangulo = height x width



    var height = shape["Height"] as Int
    var width = shape["Width"] as Int

    var Area = width * height


    return Area
}

fun calcArea2(shape : Map<String, Any>) : Int {
    // receber shape , e retornar a area do triangulo
    // area do retangulo = height x width
    return shape["Height"] as Int * shape["Width"] as Int
}





