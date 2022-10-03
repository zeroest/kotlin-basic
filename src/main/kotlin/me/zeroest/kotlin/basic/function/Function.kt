package me.zeroest.kotlin.basic.function

class Function

fun main() {

    println(String.format("sum01: %d", sum01(0, 1)))
    println(String.format("sum02: %d", sum02(0, 2)))
    println(String.format("sum03: %d", sum03(0, 3)))
//    println(String.format("sum04: %d", sum04(0, 1)))
    sum05(1, 2)

    greeting()
    greeting("Java")

    log(message = "인포 로그")
    log(level = "DEBUG", "디버그 로그")
    log("WARN", "워닝 로그")
    log(level = "ERROR", message = "에러 로그")
    log(message = "반전 로그", level = "REVERSE")

}

// 기본 함수 선언
fun sum01(a: Int, b: Int): Int {
    return a + b
}

// 표현식 스타일
fun sum02(a: Int, b: Int): Int = a + b

// 반환타입 생략 가능
fun sum03(a: Int, b: Int) = a + b

// body가 있는 함수는 반환 타입 제거 불가
//fun sum04(a: Int, b: Int) {
//    return a + b
//}

// 반환타입이 없는 함수는 Unit을 반환한다
fun sum05(a: Int, b: Int)/*: Unit*/ {
    println("$a + $b = ${a + b}")
}

// 디폴트 파라미터
fun greeting(name: String = "Kotlin") {
    println("Hello, $name")
}

// 네임드 아규먼트
fun log(level: String = "INFO", message: String) {
    println("[$level] $message")
}
