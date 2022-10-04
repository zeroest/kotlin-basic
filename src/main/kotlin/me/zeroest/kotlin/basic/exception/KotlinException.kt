package me.zeroest.kotlin.basic.exception

import java.lang.IllegalArgumentException

fun main() {
    // 코틀린은 체크드 익셉션을 try-catch, throws를 강제하지 않는다
    Thread.sleep(1)

    // 에러를 핸들링 하고 싶다면 try-catch를 사용해도 무방하다
    try {
        throw Exception("Hello, Exception")
    } catch (e: Exception) {
        println("Exception: ${e.message}")
    } finally {
        println("finally")
    }

    // try-catch는 표현식이다
    val number01 = try {
        "123".toInt()
    } catch (e: NumberFormatException) {
        println("Catch: ${e.message}")
    }
    println(number01)

    val number02 = try {
        "123-A".toInt()
    } catch (e: NumberFormatException) {
        println("Catch: ${e.message}")
    }
    println(number02)
    /*
    Catch: For input string: "123-A"
    kotlin.Unit
    */

    // throw는 표현식이다
    val str: String? = null
    // 엘비스 연산자와 Nothing 타입을 함께 사용해 값이 널이 아님을 보장하도록 한다
    val strClone: String = str ?: failFast("str is null")
    println(strClone.length)

    failFast("Erorrroororororor")

    // Unreachable code
    println("After Errorrororoorr")

}

// Nothing 타입을 사용하면 컴파일러는 해당 코드 이후는 실행되지 않는다는 경고를 보여준다
// Unit과 다르게
fun failFast(message: String): Nothing {
    throw IllegalArgumentException(message)
}