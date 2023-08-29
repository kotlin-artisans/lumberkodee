import java.io.FileInputStream
import java.util.Properties

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

    // Required for publishing library to GitHub Packages
    id("maven-publish")
}

detekt {
    config.setFrom(file("config/detekt/detekt.yml"))

    parallel = true
    autoCorrect = true
}

publishing {
    val localProperties = Properties().apply {
        load(FileInputStream(rootProject.file("local.properties")))
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/kotlin-artisans/${project.name}")
            credentials {
                username = "${localProperties["maven.gh.pkg.username"]}"
                password = "${localProperties["maven.gh.pkg.pat"]}"
            }
        }
    }

    publications {
        register("release", MavenPublication::class) {
            artifactId = project.name
            groupId = "com.github.kotlin-artisans"
            version = "0.0.1"
            artifact("$buildDir/libs/${project.name}.jar")

            /* Copied from: https://medium.com/@stpatrck/publish-an-android-library-to-github-packages-8dfff3ececcb */
            pom {
                withXml {
                    val dependencies = asNode().appendNode("dependencies")
                    configurations.implementation.get().dependencies.forEach {
                        if (it.group != null &&
                            "unspecified" != it.name &&
                            it.version != null
                        ) {
                            val dependencyNode = dependencies.appendNode("dependency")
                            dependencyNode.appendNode("groupId", it.group)
                            dependencyNode.appendNode("artifactId", it.name)
                            dependencyNode.appendNode("version", it.version)
                        }
                    }
                }
            }
        }
    }
}

tasks.withType<AbstractPublishToMaven> {
    dependsOn("build")
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

    // Use mockk for mocking objects in tests.
    testImplementation("io.mockk:mockk:1.13.7")

    // Enable automatic formatting
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.23.0")
}
