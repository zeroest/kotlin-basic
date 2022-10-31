package me.zeroest.kotlin.basic.generic

class MyGenerics<out T>(val t: T) {
}

class Bag<T> {
    fun saveAll(
        to: MutableList<in T>,
        from: MutableList<T>,
    ) {
        to.addAll(from)
    }
}

fun main() {
    // 타입 추론 가능시 제네릭 생략
//    val generics = MyGenerics<String>("테스트")
    val generics = MyGenerics("테스트")

    // 변수의 타입에 제네릭을 사용한 경우
    val list1: MutableList<String> = mutableListOf()

    // 타입 아규먼트를 생성자에서 추가
    val list2 = mutableListOf<String>()

    val list3: List<*> = listOf<String>("테스트")
    val list4: List<*> = listOf<Int>(1,2,3,4)

    // 변성
    // PECS(Producer-Extends, Consumer-Super)
    // 무공변성 같은 타입
    // 공변성 - 자바 : extends = 코틀린 : out
    // 반공변성 - 자바 : super = 코틀린 : in

    val stringGenerics: MyGenerics<String> = MyGenerics("테스트")
    val charGenerics: MyGenerics<CharSequence> = stringGenerics

    println("==================================================")

    val bag = Bag<String>()
    bag.saveAll(
        to = mutableListOf<CharSequence>("1", "2"),
        from = mutableListOf<String>("3", "4")
    )

}
