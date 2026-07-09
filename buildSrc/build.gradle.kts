plugins {
    `java-library`
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

configurations {
    implementation {
        resolutionStrategy.failOnVersionConflict()
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
