package me.zeroest.kotlin.basic.lambda

//val func: () -> Unit = {}
val printHello: () -> Unit = { println("Hello") }

// 함수를 인자로 받아 실행하는 함수
fun call(block: () -> Unit) {
    block()
}

// 아래와 같은 형식으로 선언해줘야 1급 객체로 취급할 수 있다.
fun printNo() = println("No")
//val printNo: () -> Unit = { println("No")}

val printMessage1: (String) -> Unit = { message: String -> println(message) }
val printMessage2: (String) -> Unit = { message -> println(message) }
val printMessage3: (String) -> Unit = { println(it) }

val plus: (Int, Int) -> Int = { a, b -> a + b }

fun main() {
    val list = mutableListOf(printHello)
    list[0]()
    list[0].invoke()

    val func = list[0]
    func()

    println("==============================")

    call(printHello)

//    val funPrintNo = printNo
//    mutableListOf(printNo)
//    call(printNo)

    println("==============================")

    println("plus: ${plus(1, 3)}")
}
