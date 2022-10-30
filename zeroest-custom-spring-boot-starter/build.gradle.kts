dependencies {
    api(project(":zeroest-custom"))
    api(project(":zeroest-custom-spring-boot-autoconfigure"))
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
