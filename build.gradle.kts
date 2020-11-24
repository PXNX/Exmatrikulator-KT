import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.20"
    //id "com.github.johnrengelman.shadow" version "4.0.2" // 5.0.0
}
group = "pxnx.exmat-kt"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}
dependencies {
    implementation(kotlin("stdlib-jdk8"))
    //  implementation("mysql.mysql-connector-java:8.0.22" )
    implementation("mysql:mysql-connector-java:8.0.22")
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
