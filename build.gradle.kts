/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin library project to get you started.
 */

plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.8.22"

    // Apply the java-library plugin for API and implementation separation.
    `java-library`

    id("io.gitlab.arturbosch.detekt") version "1.23.0"
}

detekt {
    config.setFrom(file("config/detekt/detekt.yml"))

    parallel = true
    autoCorrect = true
}

/**
 * Runs example project application
 */
task("run", type = Exec::class) {
    workingDir = file("example")
    commandLine("./gradlew", "run")
}

repositories {
    mavenCentral()
}

dependencies {
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // Use the Kotlin JUnit integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

    // Enable automatic formatting
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.23.0")
}
