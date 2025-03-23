plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "uk.co.mhl.timezones.core.data"
}

dependencies {
    api(project(":core:local"))
}