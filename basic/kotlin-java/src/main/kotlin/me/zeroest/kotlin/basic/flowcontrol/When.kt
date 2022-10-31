package me.zeroest.kotlin.basic.flowcontrol

fun main() {

    val dayNumber = 2
    val day = when (dayNumber) {
        1 -> "월요일"
        2 -> "화요일"
        3 -> "수요일"
        4 -> "목요일"
        5 -> "금요일"
        6 -> "토요일"
        7 -> "일요일"
        else -> "오류"
    }
    println("Day: $day")

    /*
    * enum의 모든 경우를 구현했을 경우 else 생략 가능
    * 모두 구현하지 않고 else 생략했을시 컴파일 오류 발생
    * 'when' expression must be exhaustive, add necessary 'BLUE' branch or 'else' branch instead
    * */
    val targetColor = Color.RED
    val color = when (targetColor) {
        Color.RED -> "red"
        Color.GREEN -> "green"
        Color.BLUE -> "blue"
    }
    println("Color: $color")

    // 여러 조건을 콤마로 한줄에 정의
    val targetNumber = 1
    val number = when (targetNumber) {
        0, 1 -> "0 or 1"
        else -> "other"
    }
    println("Number: $number")

}


enum class Color {
    RED, GREEN, BLUE
}