plugins {
    alias(libs.plugins.timezonetracker.android.application)
    alias(libs.plugins.timezonetracker.android.application.compose)
}

android {
    namespace = "uk.co.mhl.timezonetracker"

    defaultConfig {
        applicationId = "uk.co.mhl.timezonetracker"
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    // Feature
    implementation(project(":feature:timezones"))

    // Core
    implementation(project(":core:designsystem"))

    // Compose
    implementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(platform(libs.androidx.compose.bom))

    // Foundations
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)

    // UI
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    debugImplementation(libs.androidx.compose.ui.tooling)
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.compose.ui.test.manifest)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
}