
# Inheritance

- 자바에서 클래스의 루트에 Object가 있는 것처럼  
  코틀린은 Any가 루트 클래스로 존재
  
- 코틀린의 클래스는 기본적으로 final 클래스이기 때문에 상속을 막고  
  필요시 open 키워드를 명시하여 상속을 가능하게 한다
  
```kotlin
package kotlin

/**
 * The root of the Kotlin class hierarchy. Every Kotlin class has [Any] as a superclass.
 */
public open class Any {
  /**
   * Indicates whether some other object is "equal to" this one. Implementations must fulfil the following
   * requirements:
   *
   * * Reflexive: for any non-null value `x`, `x.equals(x)` should return true.
   * * Symmetric: for any non-null values `x` and `y`, `x.equals(y)` should return true if and only if `y.equals(x)` returns true.
   * * Transitive:  for any non-null values `x`, `y`, and `z`, if `x.equals(y)` returns true and `y.equals(z)` returns true, then `x.equals(z)` should return true.
   * * Consistent:  for any non-null values `x` and `y`, multiple invocations of `x.equals(y)` consistently return true or consistently return false, provided no information used in `equals` comparisons on the objects is modified.
   * * Never equal to null: for any non-null value `x`, `x.equals(null)` should return false.
   *
   * Read more about [equality](https://kotlinlang.org/docs/reference/equality.html) in Kotlin.
   */
  public open operator fun equals(other: Any?): Boolean

  /**
   * Returns a hash code value for the object.  The general contract of `hashCode` is:
   *
   * * Whenever it is invoked on the same object more than once, the `hashCode` method must consistently return the same integer, provided no information used in `equals` comparisons on the object is modified.
   * * If two objects are equal according to the `equals()` method, then calling the `hashCode` method on each of the two objects must produce the same integer result.
   */
  public open fun hashCode(): Int

  /**
   * Returns a string representation of the object.
   */
  public open fun toString(): String
}
```


