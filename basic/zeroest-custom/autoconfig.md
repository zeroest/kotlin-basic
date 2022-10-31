
# Auto Configuration

스프링 관련 프레임워크, 라이브러리 추가시 최적화된 자동 설정을 내장

## 메타데이터 설정

- spring-boot-autoconfigure
  - META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports
  - Spring boot 2.7 이하 버전에서는 META-INF/spring.factories 참조
- 위 파일 내에 자동설정을 구현한 Candidate 클래스들의 목록이 등록
- @EnableAutoConfiguration 에너테이션이 존재하면 자동 설정 클래스를 검색하고 조건에 따라 자동설정 클래스 로드

## AutoConfiguration Conditional

- 사용조건에 따라 사용되는 필요한 클래스만 로드
- 조건부 에너테이션(`@Conditional`)을 사용해 조건에 따라 자동설정 클래스 로드
  - spring-context -> Conditional
- 자주 사용되는 조건의 경우 PreDefined - @ConditionalOn*
  - ConditionalOnClass, ConditionalOnMissingClass
    - 클래스가 존재하는 경우에만, 클래스가 존재하지 않는 경우에만 동작
  - ConditionalOnBean, ConditionalOnMissingBean
    - 빈이 애플리케이션 컨텍스트에 존재하는 경우에만 동작, 빈이 애플리케이션 컨텍스트에 존재하지 않는 경우에만 동작
- 예시
  ```kotlin
  @AutoConfiguration
  @ConditionalOnProperty(prefix = "spring.aop", name = "auto", havingValue = "true", matchIfMissing = true)
  public class AopAutoConfiguration
  ```
  - @ConditionalOnProperty
    - spring.aop.auto 프로퍼티가 있는지 검사하고 이 값이 havingValue와 같으면 동작
    - `spring.aop.auto=true`
    - matchIfMissing 값을 통해 설정값이 존재하지 않을때 Default 값을 설정
