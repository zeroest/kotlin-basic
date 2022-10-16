package me.zeroest.kotlin.basic.generic

enum class StateKotlin(
    private val stateName: String,
    private val sortOrder: Int
) : SummaryState {
    INIT("시작", 1),
    IN_PROGRESS("진행중", 2),
    COMPLETED("완료", 3);

    override fun getStateCode(): String {
        return name
    }

    override fun getStateName(): String {
        return stateName
    }

    override fun getSortOrder(): Int {
        return sortOrder
    }
}