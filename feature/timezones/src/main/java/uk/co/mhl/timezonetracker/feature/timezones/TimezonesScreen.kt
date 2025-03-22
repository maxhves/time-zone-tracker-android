package uk.co.mhl.timezonetracker.feature.timezones

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TimezonesScreen(
    onNewTimezoneClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TimezonesScreen(
        savedTimezones = emptyList(),
        modifier = modifier,
    )
}

@Composable
internal fun TimezonesScreen(
    savedTimezones: List<String>,
    modifier: Modifier = Modifier,
) {
    Scaffold { innerPadding ->
        Text(
            modifier = Modifier.padding(innerPadding), text = "Hello"
        )
    }
}