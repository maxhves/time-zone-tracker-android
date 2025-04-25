import org.gradle.internal.extensions.stdlib.capitalized
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.timezonetracker.android.library)
    alias(libs.plugins.timezonetracker.hilt)
    alias(libs.plugins.protobuf)
}

android {
    namespace = "uk.co.mhl.timezonetracker.core.datastore"
}

protobuf {
    protoc {
        artifact = libs.protobuf.protoc.get().toString()
    }

    generateProtoTasks {
        all().forEach { task ->
            task.builtins {
                register("java") {
                    option("lite")
                }
                register("kotlin") {
                    option("lite")
                }
            }
        }
    }
}

androidComponents {
    onVariants(selector().all()) { variant ->
        afterEvaluate {
            val capName = variant.name.capitalized()
            tasks.getByName<KotlinCompile>("ksp${capName}Kotlin") {
                setSource(tasks.getByName("generate${capName}Proto").outputs)
            }
        }
    }
}

dependencies {
    api(project(":core:model"))
    api(libs.androidx.datastore)
    api(libs.protobuf.kotlin.lite)

    testImplementation(libs.kotlinx.coroutines.test)
}