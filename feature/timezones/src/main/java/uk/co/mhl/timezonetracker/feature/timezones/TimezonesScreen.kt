package uk.co.mhl.timezonetracker.feature.timezones

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TimezonesScreen(
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier.background(MaterialTheme.colorScheme.primary).padding(16.dp),
        text = "Hello from the Timezones screen",
        color = MaterialTheme.colorScheme.onPrimary,
    )
}