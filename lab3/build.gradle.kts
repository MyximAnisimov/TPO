plugins {
    kotlin("jvm") version "2.1.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.seleniumhq.selenium:selenium-java:4.31.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.12.1")
    implementation("io.github.bonigarcia:webdrivermanager:5.5.3")
    implementation("org.seleniumhq.selenium:selenium-firefox-driver:4.10.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(11)
}