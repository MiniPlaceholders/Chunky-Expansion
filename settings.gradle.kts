@file:Suppress("UnstableApiUsage")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "MiniPlaceholders-Example-Expansion"

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.fabricmc.net/")
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven("https://papermc.io/repo/repository/maven-public/")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
    id("fabric-loom") version "1.4.5"
    id("org.spongepowered.gradle.plugin") version "2.2.0"
}

arrayOf("common", "paper", "velocity", "sponge", "fabric").forEach {
    include("example-expansion-$it")

    project(":example-expansion-$it").projectDir = file(it)
}

