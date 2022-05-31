package fizzbuzz

// Desafio
// Se o número for múltiplo de 3 (mas não múltiplo de 5), o aluno deve falar "fizz" em vez do número.
// Se o número for múltiplo de 5 (mas não múltiplo de 3), a aluna deve falar "buzz" em vez do número.
// Se o número for múltiplo de 3 e múltiplo de 5, o aluno deve falar "fizzbuzz" em vez do número.
// Caso contrário, a aluna deve falar o número. Por exemplo, "quatro".

fun fizzbuzz(start: Int, end: Int): Unit {
    for (localNumber in start..end) {
        if (localNumber % 3 == 0 && localNumber % 5 == 0)
            println("Fizz Buzz")
        else if (localNumber % 3 == 0)
            println("Fizz")
        else if (localNumber % 5 == 0)
            println("Buzz")
        else
            println(localNumber)
    }
}

fun main() {
    fizzbuzz(start = 1, end = 15)
}