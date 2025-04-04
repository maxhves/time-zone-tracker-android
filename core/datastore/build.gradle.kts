plugins {
    alias(libs.plugins.timezonetracker.android.library)
    alias(libs.plugins.timezonetracker.hilt)
}

android {
    namespace = "uk.co.mhl.timezonetracker.core.datastore"
}

dependencies {
    api(project(":core:model"))
}