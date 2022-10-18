package me.zeroest.kotlin.basic.lambda

import arrow.core.andThen

/**
 * https://arrow-kt.io/
 */

//sampleStart
val throwsSomeStuff: (Int) -> Double = {x -> x.toDouble()}
val throwsOtherThings: (Double) -> String = {x -> x.toString()}
val moreThrowing: (String) -> List<String> = {x -> listOf(x)}
val magic: (Int) -> List<String> = throwsSomeStuff.andThen(throwsOtherThings).andThen(moreThrowing)

//sampleEnd
fun main() {
    println ("magic = ${magic(123)}")
}