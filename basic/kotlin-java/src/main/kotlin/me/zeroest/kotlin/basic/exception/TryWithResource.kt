package me.zeroest.kotlin.basic.exception

import java.io.FileWriter

fun main() {
    // use 내부에서 close 메서드 호출
    FileWriter("test.txt")
        .use {
            it.write("Hello Kotlin")
        }
}
