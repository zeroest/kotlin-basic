package me.zeroest.kotlin.basic.gettersetter

import java.time.LocalDate

class Student {

    var name: String? = null

    var birthDate: LocalDate? = null

    @JvmField // getter setter를 생성하지 말라
    var age: Int = 30

    var address: String? = null
        private set

    fun changeAddress(address: String) {
        this.address = address
    }
}