package me.zeroest.kotlin.basic.scopefunction

class DatabaseClient {
    var url: String? = null
    var username: String? = null
    var password: String? = null

    fun connect(): Boolean {
        println("DB Connecting...")
        Thread.sleep(1000)
        println("DB Connected")
        return true
    }
}

fun main() {
/*
    val client = DatabaseClient()
    client.url = "localhost:3306"
    client.username = "mysql"
    client.password = "1234"
    val connected = client.connect()
    println("DB connected: $connected")
*/

/*
    let으로도 처리 가능하나 it이 중복으로 사용
    val connected = DatabaseClient().let {
        it.url = "localhost:3306"
        it.username = "mysql"
        it.password = "1234"
        it.connect() // 결과값 반환
    }
*/

    val connected = DatabaseClient().run {
        this.url = "localhost:3306"
        username = "mysql"
        password = "1234"
        connect() // 결과값 반환
    }
    println("DB connected: $connected")

    // with로 표현 가능
    val withConnected = with(DatabaseClient()) {
        this.url = "localhost:3306"
        username = "mysql"
        password = "1234"
        connect() // 결과값 반환
    }
    println(withConnected)
}
