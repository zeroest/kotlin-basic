package me.zeroest.kotlin.basic.classproperty

class HomeCoffee(
    var name: String,
    val price: Int,
    var iced: Boolean = false,
) {
    val brand: String
        get() = "HOMEEMOH" // Custom getter

    var quantity: Int = 0
        set(value) {
            if (value > 0) {
                // field라는 식별자를 통해 필드의 참조에 접근, 이를 Backing Field에 접근한다고 한다
                field = value
                // 코틀린에서 프로퍼티에 값을 할당할때 실제론 setter를 사용하는데 이때 무한 재귀(StackOverFlow)가 발생할 수 있다.
//                quantity = value
            }
        }
}

fun main() {
    val homeCoffee = HomeCoffee(name = "HomeMadeCoffee", price = 0)

    // var로 선언된 프로퍼티는 getter, setter 자동으로 생성한다
    // Setter
    homeCoffee.name = "HomeMade"
    // Getter
    println(homeCoffee.name)

    // val로 선언된 프로퍼티는 getter만 존재한다
//    homeCoffee.price = 1_000 // Val cannot be reassigned

    // 커스텀 getter 생성가능
    println(homeCoffee.brand)

    // var로 선언된 프로퍼티에 한하여 커스텀 setter 생성가능
    homeCoffee.quantity = -1
    println(homeCoffee.quantity)
    homeCoffee.quantity = 100
    println(homeCoffee.quantity)

}
