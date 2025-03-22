package uk.co.mhl.timezonetracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uk.co.mhl.timezonetracker.core.designsystem.theme.TimezoneTrackerTheme
import uk.co.mhl.timezonetracker.feature.timezones.TimezonesScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TimezoneTrackerTheme {
                TimezonesScreen(
                    onNewTimezoneClick = { }
                )
            }
        }
    }
}