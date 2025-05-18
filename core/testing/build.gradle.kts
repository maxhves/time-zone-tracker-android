plugins {
    alias(libs.plugins.timezonetracker.android.library)
    alias(libs.plugins.timezonetracker.hilt)
}

android {
    namespace = "uk.co.mhl.timezonetracker.core.testing"
}

dependencies {
    api(libs.kotlinx.coroutines.test)

    api(project(":core:data"))
    api(project(":core:model"))
}