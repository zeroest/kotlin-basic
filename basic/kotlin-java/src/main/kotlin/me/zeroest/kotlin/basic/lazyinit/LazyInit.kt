package me.zeroest.kotlin.basic.lazyinit

import kotlin.random.Random

class HelloBot {
    // 나중에 값을 입력하게 하기 위해서 var 선언과 nullable 해야한다. 이는 버그발생률을 높인다.
    var greeting: String? = null
    fun sayGreeting() = println(greeting)


    /*
    val 선언으로 불변을 유지하며 초기화를 지연시킬 수 있다.
    by lazy 는 스레드세이프함

    지연초기화(by lazy) 사용 전제조건으로 val 불변해야한다. (var 선언 불가)
    var hello: String by lazy { getHello() }
    */
    val hello: String by lazy/*(LazyThreadSafetyMode.SYNCHRONIZED)*/ {
        println("초기화는 단 한번만 수행된다")
        getHello()
    }
    fun sayHello() = println(hello)

}
/*
public enum class LazyThreadSafetyMode {

    /**
     * Locks are used to ensure that only a single thread can initialize the [Lazy] instance.
     */
    SYNCHRONIZED,

    /**
     * Initializer function can be called several times on concurrent access to uninitialized [Lazy] instance value,
     * but only the first returned value will be used as the value of [Lazy] instance.
     */
    PUBLICATION,

    /**
     * No locks are used to synchronize an access to the [Lazy] instance value; if the instance is accessed from multiple threads, its behavior is undefined.
     * This mode should not be used unless the [Lazy] instance is guaranteed never to be initialized from more than one thread.
     */
    NONE,
}
*/

fun getGreeting() = "Greeting"
fun getHello() = "Hello"

fun main() {

    val helloBot = HelloBot()

    helloBot.greeting = getGreeting()
    helloBot.sayGreeting()

    for (i in 1 .. 5) {
        Thread {
//            Thread.sleep(Random.nextLong(10, 1000))
            println("[${Thread.currentThread().name}] $i. ${helloBot.hello}")
        }.start()
    }

}
