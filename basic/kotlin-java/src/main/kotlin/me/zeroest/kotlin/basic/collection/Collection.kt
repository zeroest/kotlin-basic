package me.zeroest.kotlin.basic.collection

import java.util.*
import kotlin.collections.ArrayList

fun main() {

    // immutable list
    val immutableCurrencyList: List<String> = listOf("달러", "유로", "원")
//    immutableCurrencyList.add()

    // mutable list
//    val mutableCurrencyList = mutableListOf<String>()
//    mutableCurrencyList.add("달러")
//    mutableCurrencyList.add("유로")
//    mutableCurrencyList.add("원")
    val mutableCurrencyList: MutableList<String> = mutableListOf<String>().apply {
        add("달러")
        add("유로")
        add("원")
    }

    // immutable set
    val immutableSet: Set<Int> = setOf<Int>(1, 2, 3, 4)

    // mutable set
    val mutableSet: MutableSet<Int> = mutableSetOf<Int>().apply {
        add(1)
        add(2)
        add(3)
        add(4)
    }

    // immutable map
    val immutableMap: Map<String, Int> = mapOf("one" to 1, "two" to 2)

    // mutable map
    val mutableMap: MutableMap<String, Int> = mutableMapOf<String, Int>()
    mutableMap["one"] = 1
    mutableMap.put("two", 2) // map.put() should be converted to assignment

    // collection builder
    val numberList: List<Int> = buildList {
        // 컬렉션 빌더 내부에서는 this: MutableList<Int> 즉 mutable하게 관리되고
        // 반환시 immutable한 객체를 반환한다. 즉 외부에서 사용시 ImmutableList 로 사용된다
        add(1)
        add(2)
        add(3)
    }
//    numberList.add(4);

    // linkedList
    val linkedList: LinkedList<Int> = LinkedList<Int>().apply {
        addFirst(3)
        add(2)
        addLast(1)
    }
    linkedList.add(4)

    // arrayList
    val arrayList: ArrayList<Int> = ArrayList<Int>().apply {
        add(1)
        add(2)
        add(3)
    }

    val iterator: Iterator<String> = immutableCurrencyList.iterator()
    while (iterator.hasNext()) println(iterator.next())

    println("=========================")

    for (currency in mutableCurrencyList) {
        println(currency)
    }

    println("=========================")

    immutableCurrencyList.forEach {
        println(it)
    }

    println("=========================")


    // map
    val lowerList: List<String> = listOf("a", "b", "c")
    val upperList: MutableList<String> = mutableListOf()

    val toCollection: List<String> = lowerList.map {
        it.uppercase()
    }

    println(upperList)
    println(toCollection)

    // filter
    val filteredList = toCollection.filter { it == "A" || it == "C" }
    println(filteredList)

    /*
    asSequence 를 사용하지 않으면 filter 와 같은 연산에 대해서 새로운 컬렉션을 매번 반환함
    이는 메모리 낭비로 이어지고 OOM 발생 여지를 남김
    따라서 asSequence를 통해 sequence 로변환하여 toList 와 같이 최종 터미널 오퍼레이터를 만났을때 컬렉션으로 반환한다.
    */
    val toList = toCollection
        .asSequence()
        .filter { it == "A" || it == "C" }
        .filter { it == "C" }
        .toList()
    println(toList)


}
