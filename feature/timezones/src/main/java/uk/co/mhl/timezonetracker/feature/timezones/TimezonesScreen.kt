package uk.co.mhl.timezonetracker.feature.timezones

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import uk.co.mhl.timezonetracker.core.designsystem.theme.Purple40

@Composable
fun TimezonesScreen(
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        text = "Hello from the Timezones screen",
        color = Purple40,
    )
}