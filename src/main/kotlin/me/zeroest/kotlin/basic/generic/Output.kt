package me.zeroest.kotlin.basic.generic

interface Output<T> {
    fun isArgument(argument: T): Boolean
}