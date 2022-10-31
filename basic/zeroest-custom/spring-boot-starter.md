
# Spring boot starter

스프링 부트 기반의 에플리케이션에 다른 스프링 프로젝트를 쉽게 추가할 수 있도록 만들어진 라이브러리

- 각각의 스타터에는 주축이 되는 스프링 프로젝트와 프로젝트에서 필요로 하는 필수 라이브러리가 같이 포함
- 공식 스타터는 자체 명명 규칙 `spring-boot-starter-*`
  - spring-boot-starter-web
  - spring-boot-starter-security
  
## Third party spring boot starter

공식 스프링 부트 스타터가 아닌 Third party spring boot starter 존재

- 외부 프로젝트에서 스프링 부트와 연동하기 위해 직접 만든 커스텀 스타터
- 명명 규칙 `*-spring-boot-starter`
  - mybatis-spring-boot-starter
  
## Custom spring boot starter

- zeroest-custom
  - 라이브러리에 필요한 상세 구현
- zeroest-custom-spring-boot-autoconfigure
  - zeroest-custom 라이브러리 자동설정
- zeroest-custom-spring-boot-starter
  - zeroest-custom, autoconfigure을 합친 커스텀 spring boot starter

### 적용

publishToMavenLocal 
- zeroest-custom
- zeroest-custom-spring-boot-autoconfigure
- zeroest-custom-spring-boot-starter

로컬 위치
- /home/user/.m2/repository/me/zeroest/kotlin/basic/
  - zeroest-custom
  - zeroest-custom-spring-boot-autoconfigure
  - zeroest-custom-spring-boot-starter

### Debug

VM Options에 -Ddebug 적어주는 방법
Program arguments에 --debug 적어주는 방법

```
ZeroestAutoconfiguration:
  Did not match:
     - @ConditionalOnProperty (me.zeroest.enable=true) found different value in property 'enable' (OnPropertyCondition)
  Matched:
     - @ConditionalOnClass found required class 'me.zeroest.kotlin.basic.bootstarter.HelloWorld' (OnClassCondition)
```
