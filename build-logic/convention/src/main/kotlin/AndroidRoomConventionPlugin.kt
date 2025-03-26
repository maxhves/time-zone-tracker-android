import androidx.room.gradle.RoomExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import uk.co.mhl.timezonetracker.libs

class AndroidRoomConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "androidx.room")
            apply(plugin = "com.google.devtools.ksp")

            extensions.configure<RoomExtension> {
                schemaDirectory("$projectDir/schemas")
            }

            dependencies {
                "implementation"(libs.findLibrary("androidx.room.ktx").get())
                "implementation"(libs.findLibrary("androidx.room.runtime").get())
                "ksp"(libs.findLibrary("androidx.room.compiler").get())
            }
        }
    }
}