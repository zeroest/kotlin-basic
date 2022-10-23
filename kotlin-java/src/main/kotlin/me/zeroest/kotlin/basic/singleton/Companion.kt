package me.zeroest.kotlin.basic.singleton

interface Movable {
    fun move()
}

/*
public class Person {
  public static final int MAX_AGE = 500;

  public static void sayHello() {
    System.out.println("안녕하세요~")
  }
}

public static void main() {
    System.out.println(Person.MAX_AGE);
    Person.sayHello();
}
*/
class Person {
    // 생성자 제한
//    private constructor()

    // companion object도 객체이기 때문에 interface 구현 가능
    companion object: Movable {
        const val MAX_AGE = 500
        private const val MIN_AGE = 0

        fun sayHello() = println("안녕하세요~")

        fun isMinAge(age: Int) = MIN_AGE == age

        override fun move() {
            println("이동갈비 맛있다")
        }
    }

    // Only one companion object is allowed per class
//    companion object MyCompanion {
//    }

    val b = 4321
}

class TestClass private constructor() {
    // companion object도 하나의 객체이기 때문에 이름을 붙일 수 있다
    // companion object는 설계도에 붙어 있는 객체이기 때문에 싱글톤으로 존재
    companion object Constant {
        var testNum = 123
    }
}

fun main() {
//    println(Person.Companion.MAX_AGE)
    println(Person.MAX_AGE)
//    Person.Companion.sayHello()
    Person.sayHello()
    Person.move()

//    println(TestClass.Constant.test)
    println(TestClass.testNum)
    TestClass.testNum++
    println(TestClass.testNum)
}
