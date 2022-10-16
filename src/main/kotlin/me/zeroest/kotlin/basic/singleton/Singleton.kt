package me.zeroest.kotlin.basic.singleton

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

// object 키워드를 통해 싱글톤 지원
object Singleton {
    val a = 1234
    fun printA() = println(a)
}

object DatetimeUtils {
    const val DEFAULT_FORMAT = "YYYY-mm-dd HH:MM:ss"

    val now: LocalDateTime
        get() = LocalDateTime.now()

    val nowDefaultFormat: String
        get() = this.now.format(DateTimeFormatter.ofPattern(DEFAULT_FORMAT))

    fun same(a: LocalDateTime, b: LocalDateTime): Boolean {
        return a == b
    }
}

fun main() {
    println(Singleton.a)
    Singleton.printA()

    println(DatetimeUtils.nowDefaultFormat)

    val now = DatetimeUtils.now
    println(DatetimeUtils.same(now, now))
}
