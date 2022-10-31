package me.zeroest.kotlin.basic.scopefunction

fun main() {
    val str = "Hello"

    val length: Int = with(str) {
        println("length = $length")
        this.length
    }
    println(length)

}
