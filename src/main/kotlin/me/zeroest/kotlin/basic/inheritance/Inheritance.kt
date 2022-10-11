package me.zeroest.kotlin.basic.inheritance

open class Dog(open val name: String) {
    // 함수나 프로퍼티를 재정의 할때도 마찬가지로 open 키워드로 오버라이드에 대해 허용해야 한다
    open var age: Int = 0

    open fun bark() {
        println("Bark Bark!!!")
    }
}

open class Bulldog(final override val name: String = "Bulldog"): Dog(name) {
    // 기본적으로 override된 메서드나 프로퍼티는 open 상태
    // override를 막고 싶다면 final 키워드로 막아준다
    override var age: Int = 5

    override fun bark() {
        println("Bull Dog!!!")
    }
}

class ChildBulldog(override var age: Int): Bulldog() {
    // Kotlin: 'name' in 'Bulldog' is final and cannot be overridden
//    override val name: String = "ChildBulldog"

    override fun bark() {
        print("Child ")
        super.bark()
    }
}

class Hotdog(override var age: Int = 0, override val name: String): Dog(name) {
    override fun bark() {
        println("Hot Dog!!!")
    }
}

fun main() {
    val dog = Dog("Dog")
    println("Dog name: ${dog.name}")
    println("Dog age: ${dog.age}")
    dog.bark()

    println("=================================")

    val bulldog = Bulldog()
    println("Bulldog age: ${bulldog.name}")
    println("Bulldog age: ${bulldog.age}")
    bulldog.bark()

    println("=================================")

    val childBulldog = ChildBulldog(123)
    println("Bulldog age: ${childBulldog.name}")
    println("Bulldog age: ${childBulldog.age}")
    childBulldog.bark()

    println("=================================")

    val hotdog = Hotdog(age = 10, name = "Hotdog")
    println("Hotdog name: ${hotdog.name}")
    println("Hotdog age: ${hotdog.age}")
    hotdog.bark()

    /*
    Dog name: Dog
    Dog age: 0
    Bark Bark!!!
    =================================
    Bulldog age: Bulldog
    Bulldog age: 5
    Bull Dog!!!
    =================================
    Bulldog age: Bulldog
    Bulldog age: 123
    Child Bull Dog!!!
    =================================
    Hotdog name: Hotdog
    Hotdog age: 10
    Hot Dog!!!
    */
}
