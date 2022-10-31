
# Jvm Annotation

[Reference](https://codechacha.com/ko/kotlin-annotations/)

- @JvmName
  - @JvmName은 코틀린을 바이트코드로 변환할 때 JVM 시그니쳐를 변경할 때 사용합니다. 즉, 자바에서 호출되는 코틀린 함수의 이름이 변경된다는 의미입니다.

- @JvmStatic
  - @JvmStatic은 static 변수의 get/set 함수를 자동으로 만들라는 의미입니다.
  
- @JvmField
  - @JvmField는 get/set을 생성하지 말라는 의미입니다.
  
- @JvmOverloads
  - @JvmOverloads는 코틀린 함수의 오버로딩 메소드들을 생성해주는 annotation입니다.
  
- @Throws
  - @Throws는 코틀린 함수가 예외를 던질 수 있다는 것을 표시합니다. 사실 코틀린에는 자바의 throws와 같은 코드가 없습니다.
