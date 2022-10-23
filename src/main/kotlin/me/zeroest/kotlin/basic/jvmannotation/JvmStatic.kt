package me.zeroest.kotlin.basic.jvmannotation

/**
 * @JvmStatic: static 변수의 get/set 함수를 자동으로 만들라는 의미
 */
class HelloClass {
   companion object {
       @JvmStatic
       fun hello() = "Hello!"
   }
}

object HiObject {
    @JvmStatic
    fun hi() = "Hi!"
}

fun main() {
    val hello = HelloClass.hello()
    val hi = HiObject.hi()
}
