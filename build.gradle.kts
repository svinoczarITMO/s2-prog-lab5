plugins {
    kotlin("jvm") version "1.8.10"
    kotlin("plugin.serialization") version "1.8.10"
    application
    id("org.jetbrains.dokka") version "1.7.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass.set("MainKt")
}

dependencies {
    val koinVersion = "3.2.2"
    val kotlinVersion = "1.8.0"
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.8.10")
    implementation("org.reflections:reflections:0.10.2")
    implementation(kotlin("serialization", version = kotlinVersion))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
    implementation("io.insert-koin:koin-core:$koinVersion")
    implementation ("ch.qos.logback:logback-classic:1.2.9")
    implementation ("ch.qos.logback:logback-classic:1.2.3")
}

subprojects {
    apply(plugin = "org.jetbrains.dokka")
}

tasks.test {
    useJUnitPlatform()
}