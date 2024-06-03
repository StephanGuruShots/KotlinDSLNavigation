pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "DemoDSLNavigation"
include(":app")
include(":feature:firstScreen")
include(":feature:secondScreen")
include(":feature:thirdScreen")
include(":feature:bottomNavigation")
include(":feature:firstTab")
include(":feature:secondTab")
include(":feature:thirdTab")
include(":common:presentation")
include(":feature:fourthscreen")
