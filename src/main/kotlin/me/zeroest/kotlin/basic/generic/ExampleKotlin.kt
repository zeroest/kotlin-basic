package me.zeroest.kotlin.basic.generic

fun main() {
    val builder: SummariesKotlin.Builder<Summary> = SummariesKotlin.builder<Summary, Class<StateJava>>(StateJava::class.java )
    val summaries: List<Summary> = builder.build()
}
