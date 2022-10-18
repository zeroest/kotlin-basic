package me.zeroest.kotlin.basic.destructuring

fun plus(a: Int, b: Int) = a + b
fun plus(pair: Pair<Int, Int>) = pair.first + pair.second

/**
 * 코틀린에서 Pair, Triple 의 Tuple 제공
 * */
fun main() {
    println(plus(1, 3))
    println(plus(Pair(1, 3)))

    // Pair 객체는 불변
    val aPair: Pair<String, Int> = Pair("A", 1)
    println(aPair)
//    pair.first = "B"
    // copy 함수를 통해 새로운 객체로 변환
    val bPair = aPair.copy(first = "B")
    println(bPair)

    // 불변 리스트 반환 메서드
    val bPairList: List<Comparable<*>> = bPair.toList()
    println(bPairList)

    // component 메서드를 통한, destructuring 구조분해할당
    val first = bPair.component1()
    val second = bPair.component2()
    val (b, num) = bPair

    val triple = Triple("A", "B", "C")
    println(triple)
    triple.first
    triple.second
    triple.third

    val tripleCopy = triple.copy(third = "D")
    val (one, two, three) = triple
    println("$one $two $three")

    val tripleList = triple.toList()
    val (oone, ttwo, tthree) = tripleList
    println("$oone $ttwo $tthree")

    val sixObjectList = listOf(1, 2, 3, 4, 5, 6)
    // list의 경우 5개 까지 구조분해할당 가능
    sixObjectList.component1()
    sixObjectList.component2()
    sixObjectList.component3()
    sixObjectList.component4()
    sixObjectList.component5()
//    tripleList.component6()

    // to 또한 내부적으로 Pair 구조를 가진다
    // public infix fun <A, B> A.to(that: B): Pair<A, B> = Pair(this, that)
    val map = mutableMapOf("zero" to "developer")
    // Destructuring 을 통해 편리하게 key, value를 구할 수 있다.
    for ((key, value) in map) {
        println("$key is $value")
    }

}
