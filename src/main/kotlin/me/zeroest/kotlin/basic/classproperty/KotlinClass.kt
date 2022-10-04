package me.zeroest.kotlin.basic.classproperty

// 본문 생략 가능
class EmptyClass

// constructor를 통한 기본 생성자 설정
class Person constructor(val name: String)

// constructor 생략 가능
class Animal(val name: String)

/*
프로퍼티 선언시 후행쉼표(trailing comma)를 사용
후행쉼표 사용시 이전의 마지막 줄을 수정하지 않고 프로퍼티를 쉽게 추가
git diff시 변경사항을 명확히 확인가능
*/
class Coffee(
    val name: String,
    val price: Int, // 마지막 줄에 쉼표 가능
    val brand: String,
)

// val, var 모두 사용가능
class KotlinCoffee(
    val name: String = "Kotlin",
    var price: Int = 0,
    var brand: String,
)

fun main() {
    val javaCoffee = KotlinCoffee(brand = "koffee")
//    javaCoffee.name = "Kotlin"
    javaCoffee.price = 1_000
    javaCoffee.brand = "Coffee"

    println("[Coffee] name: ${javaCoffee.name}, price: ${javaCoffee.price}, brand: ${javaCoffee.brand}")
}