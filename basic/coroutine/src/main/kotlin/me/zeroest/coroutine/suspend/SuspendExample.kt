package me.zeroest.coroutine.suspend

import kotlinx.coroutines.delay
import kotlinx.coroutines.reactive.awaitSingle
import kotlinx.coroutines.runBlocking
import reactor.core.publisher.Mono

class SuspendExample {
    suspend fun greet(who: String): String {
        delay(1000)
        return getResult(who).awaitSingle()
    }

    private fun getResult(who: String): Mono<String> {
        return Mono.just("Hello, $who!")
    }
}

fun main() {
    val suspendExample = SuspendExample()
    runBlocking {
        val greet = suspendExample.greet("zero")
        println(greet)
    }
}