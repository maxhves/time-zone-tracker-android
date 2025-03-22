plugins {
    alias(libs.plugins.timezonetracker.android.library)
    alias(libs.plugins.timezonetracker.android.library.compose)
}

android {
    namespace = "uk.co.mhl.timezonetracker.core.designsystem"
}

dependencies {
    api(libs.androidx.material3)
}