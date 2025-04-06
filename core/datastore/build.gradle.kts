plugins {
    alias(libs.plugins.timezonetracker.android.library)
    alias(libs.plugins.timezonetracker.hilt)
    alias(libs.plugins.protobuf)
}

android {
    namespace = "uk.co.mhl.timezonetracker.core.datastore"
}

dependencies {
    api(project(":core:model"))
    api(libs.androidx.datastore)
    api(libs.protobuf.kotlin.lite)
}