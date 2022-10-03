package me.zeroest.kotlin.basic.flowcontrol

fun main() {

    /*
    * Reference: https://wooooooak.github.io/kotlin/2019/02/24/kotiln_%EB%8F%99%EB%93%B1%EC%84%B1%EC%97%B0%EC%82%B0/
    *
    * 코틀린에서도 == 연산자가 기본이다. 그러나 자바와는 동작 방식에 조금 차이가 있다.
    * 원시 타입 두개를 비교할 때는 == 연산자가 동일하게 동작하지만, 참조 타입을 비교할 때 다르게 동작한다.
    * ==는 내부적으로 equals를 호출한다. 따라서 참조 타입인 두 개의 String을 ==연산으로 비교하면 주소값이 아닌 값(동등성)비교를 한다.
    *
    * 참조 타입의 주소 값을 비교(reference comparision)하고 싶다면?
    * 코틀린은 자바에는 없는 ===연산자를 지원한다. 참조 비교를 위해서 === 연산자를 사용하면 된다.
    * 즉, 자바의 주소 값 비교인 ==와 코틀린의 ===가 동일한 역할을 한다.
    * */
    val job = "Developer"
    if (job == "Developer") {
        println("Developer")
    } else {
        println("Not Developer")
    }

    /*
    * 표현식: 그 자체로 값을 만들어 낼 수 있는 문법
    * 구문: 그 자체로 값을 만들지 못함
    * */
    // if else 는 표현식이다
    val age = 10
    val result = if (age > 10) {
        "gt 10"
    } else {
        "loe 10"
    }
    println(result)

    // 코틀린은 삼항 연산자가 없다
    // if else 가 표현식이므로 불필요하다
    val a = 1
    val b = 2
    val c = if (b > a) "b > a" else if (b < a) "b < a" else "b == a"
    println(c)

}
