plugins {
    java
    id("com.github.johnrengelman.shadow") version "7.1.2"
}


group = "ru.itmo.lab"
version = "1"

repositories {
    mavenCentral()
}

dependencies {

    implementation("com.thoughtworks.xstream:xstream:1.4.19")

}

tasks.withType<Jar> {
    manifest.attributes["Main-Class"] = "ru.itmo.lab.Application"
    manifest.attributes["Class-Path"] = configurations.compileClasspath.get().joinToString(separator = " "){it.name}
}