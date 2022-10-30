import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.0" apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE"

    // 메이븐 리파지토리에 배포하기 위한 기능의 플러그인
    id("maven-publish")
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
    kotlin("kapt") version "1.6.21"
    //kotlin("plugin.noarg") version "1.6.21"
}

/*
// Class 'Person' should have [public, protected] no-arg constructor
noArg {
    annotation("javax.persistence.Entity")
}
*/

// 최상위 프로젝트를 포함한 전체 프로젝트에서 사용하는 빌드를 구성
allprojects {
    group = "me.zeroest.kotlin.basic"
    version = "0.0.0"
//    java.sourceCompatibility = JavaVersion.VERSION_17

    repositories {
        mavenLocal()
        mavenCentral()
    }
}

// settings.gradle.kts에 include에 감싸진 프로젝트의 빌드를 구성
subprojects {
    apply(plugin = "kotlin")
    apply(plugin = "kotlin-kapt")
    apply(plugin = "kotlin-spring")
    apply(plugin = "kotlin-jpa")
    apply(plugin = "maven-publish")
    apply(plugin = "io.spring.dependency-management")

    dependencyManagement {
        imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        }
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        runtimeOnly("com.h2database:h2")
        testImplementation("org.springframework.boot:spring-boot-starter-test")

        implementation("io.arrow-kt:arrow-core:1.1.2")
        // https://mvnrepository.com/artifact/org.projectlombok/lombok
        compileOnly("org.projectlombok:lombok:1.18.24")
    }
}

/*
tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}
*/
