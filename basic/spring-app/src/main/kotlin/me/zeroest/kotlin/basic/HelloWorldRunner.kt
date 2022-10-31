package me.zeroest.kotlin.basic

import me.zeroest.kotlin.basic.bootstarter.HelloWorld
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class HelloWorldRunner(
    val helloworld: HelloWorld
) : CommandLineRunner {

    val logger = LoggerFactory.getLogger(HelloWorldRunner::class.java)

    override fun run(vararg args: String?) {
        val word = helloworld.hello("zero")
        logger.info(word)
    }
}