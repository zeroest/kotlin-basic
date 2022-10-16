package me.zeroest.kotlin.basic.extensionfunction

fun String.first() : Char {
    return this[0]
}

fun String.addFirst(char: Char): String {
    return char + this.substring(0)
}

/*
public final class ExtensionFunctionKt {
   public static final char first(@NotNull String $this$first) {
      Intrinsics.checkNotNullParameter($this$first, "$this$first");
      return $this$first.charAt(0);
   }

   @NotNull
   public static final String addFirst(@NotNull String $this$addFirst, char var1) {
      Intrinsics.checkNotNullParameter($this$addFirst, "$this$addFirst");
      byte var4 = 0;
      String var10000 = $this$addFirst.substring(var4);
      Intrinsics.checkNotNullExpressionValue(var10000, "this as java.lang.String).substring(startIndex)");
      String var3 = var10000;
      return var1 + var3;
   }

   public static final void main() {
      char var0 = first("ABCD");
      System.out.println(var0);
      String var1 = addFirst("ABCD", 'Z');
      System.out.println(var1);
   }

   // $FF: synthetic method
   public static void main(String[] var0) {
      main();
   }
}
*/

/**
 * 확장기능을 이용해 사용하다 버전이 올라가 확장함수명으로 해당 클래스에 함수가 추가될경우 버그로 이어질 수 있다
*/
class MyExample {
    fun printMessage() = println("클래스 출력")
}

fun MyExample.printMessage() = println("확장 출력")
fun MyExample.printMessage(additionalMessage: String) = println("확장 출력: $additionalMessage")

// null 가능성이 있는 클래스에 대한 확장
fun MyExample?.printNullOrNotNull() {
    if (this == null) println("널인 경우에만 출력")
    else println("널이 아닌 경우에만 출력")
}

fun main() {
    println("ABCD".first())
    println("ABCD".addFirst('Z'))

    // 확장하려는 클래스에 동일한 명칭의 함수가 존재할 경우 클래스의 맴버 함수가 우선된다.
    MyExample().printMessage() // 클래스 출력
    // 함수 시그니처가 다른경우 문제 없이 확장 기능 사용
    MyExample().printMessage("추가") // 확장 출력: 추가

    var myExample: MyExample? = null
    // myExample?.printNullOrNotNull() 과 같이 안전연산자가 없어도 되는 이유는 함수 내부에서 널체크를 하고 있기 때문에 컴파일러가 NPE 발생하지 않는것을 알아 문제 없음
    myExample.printNullOrNotNull() // 널인 경우에만 출력
    myExample = MyExample()
    myExample.printNullOrNotNull() // 널이 아닌 경우에만 출력
}
