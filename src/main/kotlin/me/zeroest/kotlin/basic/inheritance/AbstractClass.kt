package me.zeroest.kotlin.basic.inheritance

abstract class Developer {
    val job: String = "Developer"

    abstract val name: String

    abstract fun code(language: String)
}

class BackendDeveloper(override val name: String) : Developer() {
    override fun code(language: String) {
        println("Code with $language")
    }
}

fun main() {
    val backendDeveloper = BackendDeveloper("홍길동")
    println("Name : ${backendDeveloper.name}")
    println("Job : ${backendDeveloper.job}")
    backendDeveloper.code("Kotlin")
}
