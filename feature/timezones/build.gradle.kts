plugins {
    alias(libs.plugins.timezonetracker.android.feature)
    alias(libs.plugins.timezonetracker.android.library.compose)
}

android {
    namespace = "uk.co.mhl.timezonetracker.feature.timezones"
}

dependencies {
    implementation(project(":core:data"))

    testImplementation(project(":core:testing"))
}