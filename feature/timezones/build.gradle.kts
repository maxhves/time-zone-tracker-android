plugins {
    id("uk.co.mhl.timezonetracker.android.feature")
    id("uk.co.mhl.timezonetracker.android.library.compose")
}

android {
    namespace = "uk.co.mhl.timezonetracker.feature.timezones"
}

dependencies {
    // TODO: Should be abstracted into :core:designsystem
    api(libs.androidx.material3)
}