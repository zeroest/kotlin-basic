package me.zeroest.kotlin.basic.classproperty

class ProCoffee(
    var name: String = "Pro Coffee",
    var price: Int = 0,
    var iced: Boolean = false,
)

fun main() {
    val proCoffee = ProCoffee()

    // 프로퍼티를 사용해 상태를 나타낼 수 있기 때문에 자바보다 객체지향적으로 코드를 작성할 수 있다
    proCoffee.iced = true
    if (proCoffee.iced) { // 객체의 상태를 프로퍼티로 표현
        println("Ice ${proCoffee.name}")
    } else {
        println("Hot ${proCoffee.name}")
    }
}
