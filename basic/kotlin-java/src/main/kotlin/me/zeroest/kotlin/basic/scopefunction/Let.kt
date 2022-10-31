package me.zeroest.kotlin.basic.scopefunction

fun main() {

    var str: String? = null

    // 안전연산자(?)를 사용해 str이 null이기 때문에 let 안의 구문 동작하지 않음
    str?.let {
        println(it)
    }

    str.let {
        println(it)
    }

    str = "Hello"
    str.let {
        println(it)
    }

    val strLetResult: Int = str.let {
        println(it)
        1234
    }
    println("strLetResult: $strLetResult")

    // Scope Function 내부에 변수선언 가능, 또한 Scope Function 호출 가능
    val abc: String? = "abc"
    abc?.let {
        val def: String? = "def"
        def?.let {
            println("abcdef가 null 아님")
        }
    }

    println("====================================")

    val hello = "hello"
    val hi = "hi"
    hello.let {
        println(it)
        hi.let {
            // hello 객체 접근 방법 없음
            println(it)
        }
    }

    println("====================================")

    hello.let { a: String ->
        println(a)
        hi.let { b ->
            // 참조 변수로 hello 객체 접근
            println(a)
            println(b)
        }
    }


}
