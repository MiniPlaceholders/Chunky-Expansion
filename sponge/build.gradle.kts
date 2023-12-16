import org.spongepowered.gradle.plugin.config.PluginLoaders
import org.spongepowered.plugin.metadata.model.PluginDependency

plugins {
    id("org.spongepowered.gradle.plugin")
}

dependencies {
    compileOnly(libs.miniplaceholders)
    implementation(projects.chunkyExpansionCommon)
}

sponge {
    apiVersion("8.1.0")
    license("GPL-3")
    loader {
        name(PluginLoaders.JAVA_PLAIN)
        version("1.0")
    }
    plugin("miniplaceholders-chunky-expansion") {
        displayName("MiniPlaceholders-Chunky-Expansion")
        entrypoint("io.github.miniplaceholders.expansion.chunky.sponge.SpongePlugin")
        description(project.description)
        links {
            homepage("https://github.com/MiniPlaceholders/Chunky-Expansion")
            source("https://github.com/MiniPlaceholders/Chunky-Expansion")
            issues("https://github.com/MiniPlaceholders/Chunky-Expansion/issues")
        }
        contributor("4drian3d") {
            description("Lead Developer")
        }
        dependency("spongeapi") {
            loadOrder(PluginDependency.LoadOrder.AFTER)
            optional(false)
        }
        dependency("miniplaceholders") {
            loadOrder(PluginDependency.LoadOrder.AFTER)
            optional(false)
            version("2.2.0")
        }
        dependency("chunky") {
            loadOrder(PluginDependency.LoadOrder.AFTER)
            optional(false)
            version("1.0.0")
        }
    }
}
