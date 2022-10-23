package me.zeroest.kotlin.basic.variable

/**
 * val(value): Immutable
 * - 자바의 final 키워드 처럼 초기화 후에 다시 초기화 불가
 * var(variable): Mutable
 * - 가변 변수 초기화 후 다시 초기화 가능
 */
fun main() {

    // 변수 선언
    val a: Int = 1
    // 타입 생략
    val b = 1

    // 지연 할당
    val c: Int
    c = 3
    // 지연할당시 타입 생략 불가
//    val d
//    d = 4

    val immutableVal = "Hello"
//    immutableVal = "world"
    var mutableVar = 123
    mutableVar = 567

    topLevelVar += 1
    println(topLevelVar)
}

// 탑 레벨 변수 선언 가능
var topLevelVar = 5
