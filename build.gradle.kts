import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.20"

    //  id("org.apache.maven.plugins.maven-jar-plugin") version "3.1.0"

    id("com.github.johnrengelman.shadow") version "5.2.0"
}
group = "pxnx.exmat-kt"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.withType<KotlinCompile> {
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

//might fix Jar
configurations {
    implementation {
        exclude("META-INF/*.SF")
        exclude("META-INF/*.DSA")
        exclude("META-INF/*.RSA")
    }
}