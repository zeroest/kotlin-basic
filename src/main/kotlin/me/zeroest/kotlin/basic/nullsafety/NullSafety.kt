package me.zeroest.kotlin.basic.nullsafety

fun main() {

    // 코틀린은 기본적으로 Non-Null타입
//    val a: String = null
    var value: String = "value"
//    value = null

    // Nullable 타입 제공
    var nullableValue: String? = null

    // Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type String?
//    nullableValue.length
    // Nullable 참조에 대한 접근은 안전 연산자(safe-call)를 사용한다
    println("Nullable 참조: ${nullableValue?.length}")
    // Nullable 참조: null

    /*
    * 엘비스 연산자를 사용해 null이 아닌 경우 특정 값을 사용하도록 한다.
    * ?: 기준 좌변이 null일경우 우변을 리턴
    * */
//    val stringLength: Int = if (nullableValue != null) nullableValue.length else 0
    val stringLength = nullableValue?.length ?: 0
    println("String length: $stringLength")

    /*
    * 코틀린에서도 NPE가 발생할 수 있다
    * 코틀린에서 자바 코드를 사용할시 항상 Nullable 가능성을 염두해 안전 연산자와 엘비스 연산자를 사용하자!!!
    * */
    // !! NotNull임을 단언하는 연산자 사용시
    val length = nullableValue!!.length
    // 자바에서 NPE를 유발하는 코드를 코틀린에서 사용시 발생 가능
    NullClass.getNullStr().length
//    val length = NullClass.getNullStr()?.length ?: 0
    // 명시적 NPE 호출
    throw NullPointerException()

}
