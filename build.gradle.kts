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
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.8.10")
    implementation("org.reflections:reflections:0.10.2")
    implementation(kotlin("serialization", version = kotlinVersion))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
    implementation("io.insert-koin:koin-core:$koinVersion")
    implementation ("ch.qos.logback:logback-classic:1.2.9")
    testImplementation ("io.mockk:mockk:1.13.4")
    testImplementation("io.insert-koin:koin-test-junit5:$koinVersion")
    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlinVersion")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
}

subprojects {
    apply(plugin = "org.jetbrains.dokka")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "MainKt"
    }
    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}