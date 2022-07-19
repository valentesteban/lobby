import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("com.github.johnrengelman.shadow") version ("7.0.0")
}

val pluginName = "Lobby"

group = "me.joesvart.$pluginName"
version = "1.0.0"

dependencies {
    compileOnly("org.spigotmc:spigot:1.8.8-R0.1-SNAPSHOT")
    compileOnly("me.clip:placeholderapi:2.10.9")
    compileOnly("org.projectlombok:lombok:1.18.22")

    api(project(":api"))

    implementation("team.unnamed:inject:1.0.0")
    implementation("team.unnamed:menu:0.1.8")
}

tasks {
    processResources {
        filesMatching("**/*.yml") {
            filter<org.apache.tools.ant.filters.ReplaceTokens>(
                "tokens" to mapOf("version" to project.version)
            )
        }
    }
}

tasks.withType<ShadowJar> {
    archiveFileName.set("$pluginName-$version.jar")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

