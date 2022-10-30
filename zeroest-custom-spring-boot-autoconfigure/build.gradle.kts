
dependencies {
    kapt("org.springframework.boot:spring-boot-autoconfigure-processor")
    kapt("org.springframework.boot:spring-boot-configuration-processor")

    api(project(":zeroest-custom"))

    implementation("org.springframework.boot:spring-boot")
    implementation("org.springframework.boot:spring-boot-autoconfigure")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()

            from(components["java"])
        }
    }
}

/*
kapt
  - 코틀린의 에노테이션 프로세서
  - 코틀린 언어에서 이러한 에너테이션 프로세서가 동작하도록 하는 플러그인
*/