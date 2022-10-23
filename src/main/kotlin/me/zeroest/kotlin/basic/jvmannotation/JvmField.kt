package me.zeroest.kotlin.basic.jvmannotation

class JvmFieldClass {
    companion object {
        @JvmField
        val id = 1234
        const val CODE = 1234
    }
}

object JvmFieldObject {
    @JvmField
    val name = "zero"
    const val FAMILY_NAME = "number"
}

fun main() {
    val id = JvmFieldClass.id
    val name = JvmFieldObject.name
}
