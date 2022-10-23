package me.zeroest.kotlin.basic.exception

fun getStr(): Nothing = throw Exception("예외 발생 '기본값'으로 초기화")

fun main() {
/*
    val result = try {
        getStr()
    } catch (e: Exception) {
        println(e.message)
        "기본값"
    }
*/

    val getOrElse = runCatching { getStr() }
        .getOrElse {
            println(it.message)
            "기본값"
        }
    println("getOrElse: $getOrElse")

    val getOrNull = runCatching { getStr() }
        .getOrNull()
    println("getOrNull: $getOrNull")

    val getOrDefault = runCatching { getStr() }
        .getOrDefault("기본값")
    println("getOrDefault: $getOrDefault")

    val map = runCatching { "Hello" }
        .map {
            "$it World"
        }.getOrThrow()
    println("map: $map")

/*
    val mapThrow = runCatching { "Hello" }
        .map {
            // map 내부에서 throw시 리커버리 불가
            throw Exception("mapThrow")
        }.getOrDefault("기본값")
    println("mapThrow: $mapThrow")
*/
    val mapThrow = runCatching { "Hello" }
        .mapCatching {
            throw Exception("mapThrow")
        }.getOrDefault("기본값")
    println("mapThrow: $mapThrow")

    val recover = runCatching { getStr() }
        .recover { "복구" }
        .getOrNull()
    println("recover: $recover")

    val recoverThrow = runCatching { getStr() }
        .recoverCatching { throw Exception("recoverThrow") }
        .getOrNull()
    println("recoverThrow: $recoverThrow")

    val getOrThrow = runCatching { getStr() }
        .getOrThrow()
    println("getOrThrow: $getOrThrow")

    val exceptionOrNull = runCatching { getStr() }
        .exceptionOrNull()
    exceptionOrNull?.let {
        println(it.message)
        throw it
    }

}
