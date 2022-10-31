package me.zeroest.kotlin.basic.generic

/**
 * [Refer](https://thdev.tech/kotlin/androiddev/2017/10/03/Kotlin-Generics/)
 * kotlin에서는 명시적으로 super/extends 대신 in/out 키워드를 제공하는데, 각각의 정의와 매칭은 아래와 같습니다.
 *
 * T : 별도의 Wildcard 정의가 없이 read/write 모두 가능
 * in T : Java의 ? super T와 같음. input의 약자이며 write 만 가능
 * out T : Java의 ? extends T와 같음. output의 약자이며 read 만 가능
 */
class ExampleUnitTest {
    val items = ArrayList<Output<String>>()

    init {
        items.add(object: Output<String> {
            override fun isArgument(argument: String): Boolean = false
        })
        items.add(object: Output<String> {
            override fun isArgument(argument: String): Boolean = true
        })
    }

}

private fun printAll(items: ArrayList<out Output<String>>) {
    items.indices
        .filter { items[it].isArgument("") }
        .forEach { println("item : ${items[it]}") }
}

private fun addItem(items: ArrayList<in Output<String>>) {
    items.add(object : Output<String> {
        override fun isArgument(argument: String): Boolean {
            return true
        }
    })
}

fun main() {
    val exampleUnitTest = ExampleUnitTest()
    addItem(exampleUnitTest.items)
    printAll(exampleUnitTest.items)
}
