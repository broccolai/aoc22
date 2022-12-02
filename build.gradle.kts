import org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode

plugins {
    kotlin("jvm") version "1.7.21"
}

repositories {
    mavenCentral()
}

kotlin {
    explicitApi = ExplicitApiMode.Strict
}
