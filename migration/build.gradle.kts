import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
}

group = "me.zeroest.kotlin.migration"
version = "0.0.0"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")

    runtimeOnly("com.h2database:h2")

    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // 기존 getter setter로 직/역직 렬화 해주던 것을 생성자로 지원, 기타 코틀린 지원
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    // 필수적 의존성
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // 자바 코드의 lombok을 위한 설정
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
//    testImplementation("com.ninja-squad:springmockk:3.1.1")
}

// 코틀린 컴파일 옵션 설정
tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
