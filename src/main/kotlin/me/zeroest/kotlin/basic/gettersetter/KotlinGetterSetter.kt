package me.zeroest.kotlin.basic.gettersetter

fun main() {

    // 자바 스타일 사용가능
    val person1 = Person()
    person1.setName("zero1")
    person1.setAge(30)

    println("person.getName() = ${person1.getName()}")
    println("person.getAge() = ${person1.getAge()}")

    // 코틀린 스타일 변환
    val person2 = Person()
    person2.name = "zero2"
    person2.age = 30

    println("person2.name = ${person2.name}")
    println("person2.age = ${person2.age}")

    // getter 메서드가 존재하면 프로퍼티처럼 사용 가능
    println("person2.uuid = ${person2.uuid}")

    // setter가 존재함에도 오류 발생, getter가 함께 존재해야 프로퍼티로 인식 가능
//    person2.address = "moon"
//    println("person2.address = ${person2.address}")
    person1.setAddress("moon") // setter 직접 호출시 사용가능
    println("person.myAddress() = ${person1.myAddress()}")

}
