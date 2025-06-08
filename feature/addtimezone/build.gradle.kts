plugins {
    alias(libs.plugins.timezonetracker.android.feature)
    alias(libs.plugins.timezonetracker.android.library.compose)
}

android {
    namespace = "uk.co.mhl.timezonetracker.feature.addtimezone"
}

dependencies {
    implementation(project(":core:data"))

    testImplementation(project(":core:testing"))
}