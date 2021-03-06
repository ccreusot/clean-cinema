/*
 * This file was generated by the Gradle 'init' task.
 *
 * This is a general purpose Gradle build.
 * Learn how to create Gradle builds at https://guides.gradle.org/creating-new-gradle-builds
 */
plugins {
    base
    kotlin("jvm") version "1.4.10" apply false
}

allprojects {
    repositories {
        jcenter()
    }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    dependencies {
        val implementation by configurations
        val testImplementation by configurations

        implementation(kotlin("stdlib"))
        implementation(kotlin("reflect"))

        testImplementation(kotlin("test"))
        testImplementation(kotlin("test-common"))
        testImplementation(kotlin("test-annotations-common"))
        testImplementation(kotlin("test-junit"))
        testImplementation("org.amshove.kluent:kluent:1.61")
        testImplementation("io.mockk:mockk:1.10.0")
    }
}