package me.zeroest.kotlin.basic.interfaceclass

class Product(val name: String, var price: Int)

interface Wheel {
    fun roll()
}

interface Cart: Wheel {

    // 코틀린의 인터페이스는 프로퍼티가 존재할 수 있다
    var coin: Int

    // getter 접근자를 통한 프로퍼티
    val weight: String
        get() = "20KG"

    // backing field 값에 접근 불가
    // Property in an interface cannot have a backing field
/*
    val width: String
        get() {
            field
        }
*/

    fun add(product: Product)

    // 자바 8에 디폴트 메서드처럼 구현을 가진 함수 정의 가능
    fun rent() {
        if (coin > 0) println("카트 대여")
        else println("코인 없음 카트 대여 불가")
        coin--
    }

    override fun roll() {
        println("굴러가유")
    }

    fun printId() = println(123)
}

interface Order {
    fun add(product: Product) {
        println("주문에 [${product.name}] 상품 추가")
    }

    fun printId() = println(321)
}

// 인터페이스 구현시 클래스 또는 Abstract클래스 상속과 다른점은 () 생성자가 없다
class DefaultCart(override var coin: Int) : Cart, Order {
    val list: List<Product> = ArrayList()

    override fun add(product: Product) {
        if (coin <= 0) println("코인 입력 필요")
        else println("[${product.name}] 카트 추가 완료")
        coin--

        // 동일한 시그니처가 중복될 경우 아래와 같이 특정인터페이스의 함수 사용가능
        super<Order>.add(product)
    }

    // 동일한 디폴트 함수가 존재할 경우 컴파일 오류 발생
    // 하위 구체 클래스에서 필수로 재정의 필요
    override fun printId() {
        print("Order id: ")
        super<Order>.printId()
        print("Cart id: ")
        super<Cart>.printId()
    }
}

fun main() {
    val defaultCart = DefaultCart(coin = 10)
    println("Start Coin : ${defaultCart.coin}")
    defaultCart.rent()
    defaultCart.roll()
    defaultCart.add(Product(name = "Bread", price = 1000))
    defaultCart.add(Product(name = "Milk", price = 500))
    defaultCart.coin
    println("End Coin : ${defaultCart.coin}")

    defaultCart.printId()
}
