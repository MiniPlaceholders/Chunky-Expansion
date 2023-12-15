plugins {
    java
    alias(libs.plugins.shadow)
}

dependencies {
    implementation(projects.exampleExpansionVelocity)
    implementation(projects.exampleExpansionPaper)
    implementation(projects.exampleExpansionSponge)
}

subprojects {
    apply<JavaPlugin>()
    java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))
    tasks {
        compileJava {
            options.encoding = Charsets.UTF_8.name()
            options.release.set(17)
        }
    }
}

tasks {
    shadowJar {
        archiveFileName.set("MiniPlaceholders-${rootProject.name}-${project.version}.jar")
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }
    build {
        dependsOn(shadowJar)
    }
}
