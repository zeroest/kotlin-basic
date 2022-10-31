
# Scope Function

람다식 사용시 일시적인 Scope가 생기게 되는데  
이 Scope 안에서 전달된 객체에 대해 접근할 수 있는 Context Object

| 함수명 | 수신자 객체 참조 방법 | 반환값        | 확장 함수 여부 |
| ------ | --------------------- | ------------- | -------------- |
| let    | it                    | 함수의 결과   | O              |
| run    | this                  | 함수의 결과   | O              |
| with   | this                  | 함수의 결과   | X              |
| apply  | this                  | 컨텍스트 객체 | O              |
| also   | it                    | 컨텍스트 객체 | O              |
