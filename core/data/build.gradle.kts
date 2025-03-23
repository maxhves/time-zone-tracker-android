plugins {
    alias(libs.plugins.timezonetracker.android.library)
}

android {
    namespace = "uk.co.mhl.timezones.core.data"
}

dependencies {
    api(project(":core:local"))

    implementation(libs.kotlinx.coroutines.core)
}