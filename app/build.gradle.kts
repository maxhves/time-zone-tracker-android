plugins {
    alias(libs.plugins.timezonetracker.android.application)
    alias(libs.plugins.timezonetracker.android.application.compose)
    alias(libs.plugins.timezonetracker.hilt)
    alias(libs.plugins.kotlin.serialization)
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
    // Internal
    implementation(project(":core:data"))
    implementation(project(":core:designsystem"))
    implementation(project(":core:model"))
    implementation(project(":core:ui"))
    implementation(project(":feature:addtimezone"))
    implementation(project(":feature:timezones"))

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // Compose
    implementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(platform(libs.androidx.compose.bom))

    // Foundations
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)

    // Hilt
    ksp(libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

    // Navigation
    implementation(libs.androidx.lifecycle.viewmodel.navigation3)
    implementation(libs.androidx.navigation3.runtime)
    implementation(libs.androidx.navigation3.ui)
    implementation(libs.kotlinx.serialization.json)

    // Room
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.runtime)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)

    // UI
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    debugImplementation(libs.androidx.compose.ui.tooling)
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.compose.ui.test.manifest)
}