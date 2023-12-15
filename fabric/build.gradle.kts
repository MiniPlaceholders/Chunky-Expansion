plugins {
    id("fabric-loom")
    alias(libs.plugins.shadow)
}

val shade: Configuration by configurations.creating

dependencies {
    compileOnly(libs.miniplaceholders)
    shadeModule(projects.exampleExpansionCommon)
    minecraft(libs.minecraft)
    mappings(loom.officialMojangMappings())
    modImplementation(libs.fabric.loader)
    modImplementation(libs.fabric.api)
    modImplementation(libs.adventure.platform.fabric)
}

fun DependencyHandlerScope.shadeModule(dependency: Any) {
    shade(dependency)
    implementation(dependency)
}

tasks {
    processResources {
        filteringCharset = Charsets.UTF_8.name()
        filesMatching("fabric.mod.json") {
            expand("version" to project.version)
        }
    }
    remapJar {
        inputFile.set(shadowJar.get().archiveFile)
        archiveFileName.set("MiniPlaceholders-Example-Expansion-Fabric-${project.version}.jar")
        destinationDirectory.set(file("${project.rootDir}/build"))
    }
    shadowJar {
        configurations = listOf(shade)
    }
}

java {
    withSourcesJar()
}