package me.zeroest.kotlin.basic.flowcontrol

fun main() {

    // 범위 연산자 .. 사용
    for (i in 0..3) {
        println("범위 연산자: $i")
    }
    /*
    범위 연산자: 0
    범위 연산자: 1
    범위 연산자: 2
    범위 연산자: 3
    */

    // until 사용시 뒤에 온 숫자는 포함하지 않음
    for (i in 0 until 3) {
        println("until3: $i")
    }
    /*
    until3: 0
    until3: 1
    until3: 2
    */

    // step 값 만큼 증가
    for (i in 0..7 step 2) {
        println("step2: $i")
    }
    /*
    step2: 0
    step2: 2
    step2: 4
    step2: 6
    */

    // downTo 값 까지 감소
    for (i in 3 downTo -1) {
        println("downTo-1: $i")
    }
    /*
    downTo-1: 3
    downTo-1: 2
    downTo-1: 1
    downTo-1: 0
    downTo-1: -1
    */

    val numbers = arrayOf(1, 2, 3)
    for (i in numbers) {
        println("array: $i")
    }

}
