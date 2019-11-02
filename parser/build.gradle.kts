import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-library`
    kotlin("jvm")
    `maven-publish`
}

group = "com.github.haroldadmin"
version = ProjectProperties.versionName

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(Libraries.Kotlin.stdLib)
    implementation(Libraries.Kotlin.coroutines)
    implementation(Libraries.jsoup)
    testImplementation(Libraries.Kotlin.test)
    testImplementation(Libraries.Kotlin.testJunit)
    testImplementation(Libraries.mockWebServer)
}

repositories {
    mavenCentral()
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
    freeCompilerArgs = listOf("-XXLanguage:+InlineClasses")
}