package me.zeroest.kotlin.basic.sealed

data class OtherDeveloper(override val name: String) : Developer() {
    override fun code(language: String) {
        println("Im Other $job | Code with $language")
    }
}
