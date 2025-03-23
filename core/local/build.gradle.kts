plugins {
    alias(libs.plugins.timezonetracker.android.library)
}

android {
    namespace = "uk.co.mhl.timezonetracker.core.local"
}

dependencies {
    // TODO: Consider to abstract into a separate module when used by more modules.
    implementation(libs.kotlinx.coroutines.core)
}