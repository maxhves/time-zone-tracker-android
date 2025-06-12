package uk.co.mhl.timezonetracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import uk.co.mhl.timezonetracker.core.designsystem.theme.TimeZoneTrackerTheme
import uk.co.mhl.timezonetracker.navigation.MainNavigation

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TimeZoneTrackerTheme {
                MainNavigation()
            }
        }
    }
}