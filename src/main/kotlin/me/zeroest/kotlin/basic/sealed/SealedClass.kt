package me.zeroest.kotlin.basic.sealed

/*
- 컴파일러가 특정 클래스를 상속 받는 하위 클래스는 여러개가 존재할 수 있기 때문에 얼마나 많은 하위 클래스가 있는지 모른다.
  하지만 sealed를 명시해주면 컴파일러에게 같은 패키지 내의 하위 클래스를 모두 알려주는 것과 같다. 따라서 모든 클래스를 when is 구문에 구현시 else 구문이 필요 없고 구현하지 않은 is 클래스는 컴파일 오류가 발생한다.
- 코틀린 1.6 버전 기준 같은 패키지 또는 모듈 안에 있는 경우에만 하위 클래스를 정의할 수 있다. 그 이전에는 같은 파일내에 정의해야했다.
*/
sealed class Developer {
    val job: String = "Developer"

    abstract val name: String

    abstract fun code(language: String)
}

data class BackendDeveloper(override val name: String) : Developer() {
    override fun code(language: String) {
        println("Im Backend $job | Code with $language")
    }
}

data class FrontendDeveloper(override val name: String) : Developer() {
    override fun code(language: String) {
        println("Im Frontend $job | Code with $language")
    }
}

object DeveloperPool {
    private val pool = mutableMapOf<String, Developer>()

    fun add(developer: Developer) = when (developer) {
        is BackendDeveloper -> pool[developer.name] = developer
        is FrontendDeveloper -> pool[developer.name] = developer
        is OtherDeveloper -> pool[developer.name] = developer
    /*
    Developer 클래스가 sealed 클래스가 아닌경우 else 키워드를 제거할시 컴파일 오류 발생
    else 구문을 제거하여 버그 발생을 줄일 수 있다.
    */
/*
        else -> {
            println("지원하지않는 개발자입니다.")
        }
*/
    }

    fun get(name: String) = pool[name]
}

fun main() {
    val backendDeveloper = BackendDeveloper(name = "zero")
    DeveloperPool.add(backendDeveloper)
    val frontendDeveloper = FrontendDeveloper(name = "front")
    DeveloperPool.add(frontendDeveloper)

    println(DeveloperPool.get("zero"))
    DeveloperPool.get("zero")?.code("kotlin")
    println(DeveloperPool.get("front"))
    DeveloperPool.get("front")?.code("js")
}
