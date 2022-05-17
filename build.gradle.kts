plugins {
    java
}

group = "ru.itmo.lab"
version = "1"

repositories {
    mavenCentral()
}

dependencies {

    implementation("com.thoughtworks.xstream:xstream:1.4.19")

}

jar {
    manifest {
        attributes("Main-Class": "ru.itmo.service.Application")
    }
}

