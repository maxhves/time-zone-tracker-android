package uk.co.mhl.timezonetracker.feature.timezones

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

// TODO: Implement screen here.
object TimezonesScreen {
    fun testing(): String {
        return "This is a test function"
    }
}

@Composable
fun TimezonesScreen(
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        text = "Hello from the Timezones screen"
    )
}