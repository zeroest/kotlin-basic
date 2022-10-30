package me.zeroest.kotlin.basic.bootstarter.autoconfigure

import me.zeroest.kotlin.basic.bootstarter.HelloWorld
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean

@AutoConfiguration
@ConditionalOnClass(HelloWorld::class)
@ConditionalOnProperty(prefix = "me.zeroest", name = ["enable"], havingValue = "true", matchIfMissing = false)
class ZeroestAutoconfiguration {

    @Bean
    // 사용자가 HelloWorld 빈을 재정의한 경우에 충돌이 발생 따라서 OnMissingBean을 통해 빈이 존재하지 않을 경우 로드
    @ConditionalOnMissingBean
    fun helloWorld() = HelloWorld()

}
