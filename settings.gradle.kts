@file:Suppress("UnstableApiUsage")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "MiniPlaceholders-Chunky-Expansion"

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
        maven("https://repo.codemc.io/repository/maven-public/")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
    id("fabric-loom") version "1.11.7"
    id("org.spongepowered.gradle.plugin") version "2.2.0"
}

arrayOf("common", "paper", "sponge", "fabric").forEach {
    include("chunky-expansion-$it")

    project(":chunky-expansion-$it").projectDir = file(it)
}

