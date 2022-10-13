package me.zeroest.kotlin.basic.enum

interface Payable {
    fun isPayable(): Boolean
}

enum class PaymentStatus(val label: String): Payable {
    UNPAID("미지급") {
        override fun isFailed() = false
        override fun isPayable(): Boolean = true
    },
    PAID("지급완료") {
        override fun isFailed() = false
        override fun isPayable(): Boolean = false
    },
    FAILED("지급실패") {
        override fun isFailed() = true
        override fun isPayable(): Boolean = false
    },
    REFUNDED("환불") {
        override fun isFailed() = false
        override fun isPayable(): Boolean = false
    },
    ;

    abstract fun isFailed(): Boolean
}

fun main() {
    if (PaymentStatus.UNPAID.isPayable()) {
        println("결제 가능 상태")
    }

    val paidStatus = PaymentStatus.valueOf("PAID")
    println(paidStatus.label)

    if (paidStatus == PaymentStatus.PAID) {
        println("결제 완료 상태")
    }

    PaymentStatus.values().forEach {
        println("${it.ordinal+1}. [${it.name}] ${it.label}")
    }
}
