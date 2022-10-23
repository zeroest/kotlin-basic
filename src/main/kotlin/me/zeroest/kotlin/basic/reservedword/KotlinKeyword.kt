package me.zeroest.kotlin.basic.reservedword

fun main() {
    val javaKeyword = JavaKeyword()

    // 백틱을 통해 예약어 escape 가능
//    javaKeyword.in
    javaKeyword.`in`
    javaKeyword.`in`
}

enum class CountryCodeKotlin {
    // do는 코틀린에서 또한 예약어이기 때문에 사용 불가 하나 백틱을 통해 escape 처리
    kr, jp, us, `do`
}
