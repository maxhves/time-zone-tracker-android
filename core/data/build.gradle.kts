plugins {
    alias(libs.plugins.timezonetracker.android.library)
    alias(libs.plugins.timezonetracker.hilt)
}

android {
    namespace = "uk.co.mhl.timezones.core.data"
}

dependencies {
    api(project(":core:local"))

    implementation(libs.kotlinx.coroutines.core)
}