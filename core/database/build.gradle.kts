plugins {
    alias(libs.plugins.timezonetracker.android.library)
    alias(libs.plugins.timezonetracker.hilt)
    alias(libs.plugins.timezonetracker.room)
}

android {
    namespace = "uk.co.mhl.timezonetracker.database"
}

dependencies {
    api(project(":core:model"))

    androidTestImplementation(libs.androidx.test.core)
    androidTestImplementation(libs.androidx.test.runner)
    androidTestImplementation(libs.kotlinx.coroutines.test)
}