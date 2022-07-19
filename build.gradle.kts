plugins {
    java
}

subprojects {
    apply(plugin="java-library")

    repositories {
        mavenLocal()
        mavenCentral()

        maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        maven("https://oss.sonatype.org/content/repositories/central")
        maven("https://jitpack.io")
        maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
        maven("https://repo.codemc.io/repository/nms/")
        maven("https://repo.unnamed.team/repository/unnamed-snapshots/")
        maven("https://repo.unnamed.team/repository/unnamed-releases")
        maven("https://repo.unnamed.team/repository/unnamed-public/")
    }
}