package me.zeroest.kotlin.basic.dataclass

data class Person(val name: String, val age: Int) {
    /*
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Person

        if (name != other.name) return false
        if (age != other.age) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + age
        return result
    }

    override fun toString(): String {
        return "Person(name='$name', age=$age)"
    }
*/
}

fun main() {
    val person1 = Person(name = "tony", age = 12)
    val person2 = Person(name = "tony", age = 12)
    println(person1)

    println(person1 == person2)

    val personSet = hashSetOf(person1)
    println(personSet.contains(person2))

    /*
    var 사용시 불변이 깨져
    - Hash 계열 자료구조에서 의도치 않은 버그 발생할 수 있다
    - 멀티스레드 환경에서 객체의 불변성을 유지하는 것은 동기화 처리를 줄여주고 안정성을 유지
    - 유지보수 관점에서 프로퍼티를 제 각각 변경하면 코드파악에 어려움

    copy를 사용해 val 즉 불변성을 유지하고 원하는 프로퍼티만 변경하여 새로운 불변 객체를 생성할 수 있다.
    */
//    person1.name = "strange"
//    println(personSet.contains(person2))
    val person3 = person1.copy()
    println(person3)
    val person4 = person1.copy(name = "strange")
    println(person4)

    // 데이터 클래스에 정의된 프로퍼티를 순서대로 가져올 수 있다
    println("이름='${person1.component1()}', 나이=${person1.component2()}")
    // 구조분해할당 을 사용해 좀 더 쉽고 안전하게 변수를 선언할 수 있다.
    val (name, age) = person1
    println("이름='$name', 나이=$age")
    /*
    Person person1 = new Person("tony", 12);
    String name = person1.component1();
    int age = person1.component2();
    String var3 = "이름='" + name + "', 나이=" + age;
    System.out.println(var3);
    */

}
