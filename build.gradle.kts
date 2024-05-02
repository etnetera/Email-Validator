repositories {
    mavenCentral()
}

plugins {
    id("java")
    id("cz.etn.gradle.plugin.dependency-check")
    id("cz.etn.gradle.plugin.git-properties")
    id("cz.etn.gradle.plugin.ivy-publish")
    id("cz.etn.gradle.plugin.jacoco")
    id("cz.etn.gradle.plugin.sonarqube")
}

dependencies {
    // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
}
