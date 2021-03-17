plugins {
    java
}

group = "hu.javadev"
version = "1.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenCentral()
}

val junitVersion = "5.7.1"
val assertJVersion = "3.19.0"
val mockitoVersion = "3.7.7"

dependencies {
    testImplementation(platform("org.junit:junit-bom:${junitVersion}"))
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    testImplementation("org.assertj:assertj-core:${assertJVersion}")

    testImplementation("org.mockito:mockito-core:${mockitoVersion}")
}

tasks.test {
    useJUnitPlatform()
}

tasks.wrapper {
    gradleVersion = "6.8.2"
}
