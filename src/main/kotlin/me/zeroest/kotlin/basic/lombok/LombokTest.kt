package me.zeroest.kotlin.basic.lombok

fun main() {
/*
    val hero = Hero()

    hero.name = "zero" // Kotlin: Cannot access 'name': it is private in 'Hero'
    hero.age = 30 // Kotlin: Cannot access 'age': it is private in 'Hero'
    hero.address = "moon"

    println("hero = ${hero}")
*/

    // 코틀린 코드로 마이그레이션하여 사용
    val heroKt = HeroKt(name = "zero", age = 30, address = "moon")
    println(heroKt)
}
