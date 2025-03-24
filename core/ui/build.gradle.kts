plugins {
    alias(libs.plugins.timezonetracker.android.library)
    alias(libs.plugins.timezonetracker.android.library.compose)
}

android {
    namespace = "uk.co.mhl.timezonetracker.core.ui"
}

dependencies {
    api(project(":core:designsystem"))
}