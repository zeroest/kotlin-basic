package me.zeroest.kotlin.basic.scopefunction

fun main() {
    val client: DatabaseClient = DatabaseClient().apply {
        this.url = "localhost:3306"
        username = "mysql"
        password = "1234"
        connect() // 마지막 구문과 상관 없이 컨텍스트 객체를 그대로 반환
    }

    println("==========================================")

    client.connect().run { println(this) }

    println("==========================================")

    DatabaseClient().apply {
        this.url = "localhost:3306"
        username = "mysql"
        password = "1234"
    }.connect().run { println(this) }

}
