package me.zeroest.kotlin.basic.exception

import java.io.IOException

class KotlinThrow {

    // 자바 코드와 상호변환이 필요하다면 예외전파 에너테이션을 추가하도록 한다.
    @Throws(IOException::class)
    fun throwIoException() {
        throw IOException("[KotlinThrow] IOException")
    }

}

fun main() {

    val javaThrow = JavaThrow()
    javaThrow.throwIOException();

    val kotlinThrow = KotlinThrow()
    kotlinThrow.throwIoException()

}