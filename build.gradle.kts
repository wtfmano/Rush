val kotlinVersion: String by project
val coroutinesVersion: String by project

plugins {
    java
    kotlin("jvm") version "2.0.0"
    id("org.jetbrains.dokka") version "1.9.0"
}

group = "me.austin"
version = "0.2.4"

repositories {
    mavenCentral()
}

dependencies {
    // Test library
    testImplementation(kotlin("test", kotlinVersion))

    // We need this for the rubBlocking function
    testImplementation(group = "org.jetbrains.kotlinx", name = "kotlinx-coroutines-core", version = coroutinesVersion)

    // Reflection library
    implementation(group = "org.jetbrains.kotlin", name = "kotlin-reflect", version = kotlinVersion) {
        exclude(group = "org.jetbrains.kotlin", module = "kotlin-stdlib")
    }

    // Coroutine library
    implementation(group = "org.jetbrains.kotlinx", name = "kotlinx-coroutines-core", version = coroutinesVersion)

    // Standard library
    implementation(kotlin("stdlib-jdk8", kotlinVersion))

    // Annotations
    compileOnly(group = "org.jetbrains", name = "annotations", version = "24.0.1")
}

java {
    withSourcesJar()
    withJavadocJar()

    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}

kotlin {
    jvmToolchain(8)
}

tasks {
    test {
        testLogging.showStandardStreams = true
        useJUnitPlatform()
    }

    jar {
        into("META-INF") {
            from("LICENSE")
        }
    }

    named<Jar>("javadocJar") {
        from(named("dokkaJavadoc"))
    }
}