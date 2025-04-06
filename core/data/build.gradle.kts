plugins {
    alias(libs.plugins.timezonetracker.android.library)
    alias(libs.plugins.timezonetracker.hilt)
}

android {
    namespace = "uk.co.mhl.timezonetracker.core.data"
}

dependencies {
    api(project(":core:database"))
    api(project(":core:datastore"))

    implementation(libs.kotlinx.coroutines.core)

    testImplementation(libs.kotlinx.coroutines.test)
}