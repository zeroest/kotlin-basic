package me.zeroest.kotlin.basic.lambda

fun forEachStr(collection: Collection<String>, action: (String) -> Unit) {
    for (item in collection) {
        action(item)
    }
}

fun returnFunction(): (String) -> Unit {
    val printString: (String) -> Unit = { println(it) }
    return printString
}

fun outerFunc(): () -> Unit {
// 익명 함수
/*
    return fun() {
        println("Anonymous Function Called")
    }
*/
    return {
        println("Anonymous Function Called")
    }
}
fun outerFunc2(): () -> Unit = { println("Anonymous Function Called") }

val sum1: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
val sum2: (Int, Int) -> Int = { x, y -> x + y }
val sum3 = { x: Int, y: Int -> x + y }

val printHi: () -> Unit = { println("Hi") }

fun main() {
    val list = listOf("a", "b", "c")
    val printStr: (String) -> Unit = { println(it) }

    forEachStr(list, printStr)

    println("====================================")

    list.forEach(returnFunction())

    println("====================================")

    val upperCase: (String) -> String = { it.uppercase() }
    println(list.map(upperCase))

    println("====================================")

    outerFunc()()
    val outerFunc = outerFunc()
    outerFunc()

    println("====================================")

    // 후행 람다 전달
    // 함수의 마지막 인자가 함수인 경우 사용가능
    forEachStr(list) {
        printStr(it)
    }

    // 아래도 후행 람다 전달을 통해 사용
    list.forEach {
        upperCase(it).run(printStr)
    }

    println("====================================")

//    val callReference: () -> () -> Unit = { printHi }
    val callReference = ::printHi
    callReference()()

    val numberList = listOf("1", "2", "3")
    numberList.map {
        it.toInt()
    }.forEach {
        println(it)
    }

    numberList.map(String::toInt).forEach(::println)
}
