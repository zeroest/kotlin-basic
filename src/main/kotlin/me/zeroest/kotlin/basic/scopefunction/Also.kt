package me.zeroest.kotlin.basic.scopefunction

data class User(val name: String, val password: String) {
    fun validate() {
        if (name.isNotEmpty() && password.isNotEmpty()) {
            println("검증 성공")
        } else {
            println("검증 실패")
        }
    }

    fun printName() = println(name)
}

fun main() {
/*
    val user = User(name = "zero", password = "0")
    user.validate()
*/
    val user: User = User(name = "zero", password = "0").also {
        it.validate()
        it.printName()
    }

    println(user)
}
