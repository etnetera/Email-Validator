plugins {
    `java-library`
    `kotlin-dsl`
}

val artifactoryUrl = System.getenv("ARTIFACTORY_URL")

dependencies {
    // Gradle plugins
    implementation("cz.etn.gradle.plugin:dependency-check:${property("dependency-check.version")}")
    implementation("cz.etn.gradle.plugin:git-properties:${property("git-properties.version")}")
    implementation("cz.etn.gradle.plugin:ivy-publish:${property("ivy-publish.version")}")
    implementation("cz.etn.gradle.plugin:jacoco:${property("jacoco.version")}")
    implementation("cz.etn.gradle.plugin:sonarqube:${property("sonarqube.version")}")
}

repositories {
    gradlePluginPortal()
    ivy {
        url = uri("$artifactoryUrl/etn/")
        isAllowInsecureProtocol = true
    }
}

configurations {
    implementation {
        resolutionStrategy.failOnVersionConflict()
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks {
    test {
        testLogging.showExceptions = true
        // Use the built-in JUnit support of Gradle.
        useJUnitPlatform()
    }

    wrapper {
        gradleVersion = "8.7"
        distributionType = Wrapper.DistributionType.ALL
    }
}
