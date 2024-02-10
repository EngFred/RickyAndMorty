pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "RIcky&MortyFinale"
include(":app")
include(":core:network")
include(":core:theme")
include(":feature:characters:data")
include(":feature:character_details:data")
include(":feature:characters:domain")
include(":feature:characters:ui")
include(":feature:character_details:domain")
include(":feature:character_details:ui")
include(":core:common")
include(":core:feature_api")
