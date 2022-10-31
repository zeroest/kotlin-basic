package me.zeroest.kotlin.basic.lazyinit

class TestService
class TestTarget

/**
 * lateinit 가변 프로퍼티에 대한 지연초기화가 필요한 경우
 */
class LateInit {

    // Autowired 같이 의존성 주입이 필요한 경우
//    @Autowired
    lateinit var service: TestService
    // 'lateinit' modifier is allowed only on mutable properties
//    lateinit val service: TestService
    lateinit var subject: TestTarget

    // JUnit 과 같이 setup에서 객체의 초기화가 필요한 경우
//    @SetUp
    fun setup() {
        subject = TestTarget()
    }

    lateinit var uninitialiazed: String

    lateinit var text: String

    // isInitialized 는 클래스 내부에서만 사용 가능
    // 아래와 같이 값에 대해 getter로 참조 가능
    val textInitialized: Boolean
        get() = this::text.isInitialized

    fun printText() {
        if (this::text.isInitialized) {
            println("text 이미 초기화 됨")
        } else {
            text = "Hello world"
        }
        println(text)
    }

}

fun main() {
    val lateInit = LateInit()

    println("textInitialized: ${lateInit.textInitialized}")
    lateInit.printText()
    println("textInitialized: ${lateInit.textInitialized}")
    lateInit.printText()

    println(lateInit.uninitialiazed) // UninitializedPropertyAccessException: lateinit property test has not been initialized
}
