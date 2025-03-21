plugins {
    alias(libs.plugins.timezonetracker.android.feature)
    alias(libs.plugins.timezonetracker.android.library.compose)
}

android {
    namespace = "uk.co.mhl.timezonetracker.feature.timezones"
}

dependencies {
    // TODO: Should be abstracted into :core:designsystem
    api(libs.androidx.material3)
}