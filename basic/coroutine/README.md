
# [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)

동시성 지원 라이브러리 - 비동기 non blocking으로 동작하는 코드를 동기 방식으로 작성할 수 있게 지원

[kotlinx.coroutines](https://github.com/Kotlin/kotlinx.coroutines)

[[gmarket] 코루틴(Coroutine)에 대하여](https://dev.gmarket.com/82)
> Coroutines are computer program components that allow execution to be suspended and resumed, generalizing subroutines for cooperative multitasking.
> 
> 실행의 지연과 재개를 허용함으로써, **비선점적 멀티태스킹**을 위한 **서브 루틴**을 일반화한 컴퓨터 프로그램 구성요소
> 
> [[Wikipedia] Coroutine](https://en.wikipedia.org/wiki/Coroutine)

비선점적 멀티태스킹
- 비선점형 : 하나의 프로세스가 CPU를 할당받으면 종료되기 전까지 다른 프로세스가 CPU를 강제로 차지할 수 없습니다. (코루틴)
- 선점형 : 하나의 프로세스가 다른 프로세스 대신에 프로세서(CPU)를 강제로 차지할 수 있습니다. (쓰레드)

서브 루틴
- 메인 루틴 : 프로그램 전체의 개괄적인 동작으로 main 함수에 의해 수행되는 흐름
- 서브 루틴 : 반복적인 기능을 모은 동작으로 main 함수 내에서 실행되는 개별 함수의 흐름
