package uk.co.mhl.timezonetracker.feature.timezones

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uk.co.mhl.timezonetracker.core.designsystem.theme.TimezoneTrackerTheme
import uk.co.mhl.timezonetracker.feature.timezones.components.NewTimezoneFloatingActionButton

@Composable
fun TimezonesScreen(
    onNewTimezoneClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TimezonesScreen(
        savedTimezones = emptyList(),
        onNewTimezoneClick = onNewTimezoneClick,
        modifier = modifier,
    )
}

@Composable
internal fun TimezonesScreen(
    savedTimezones: List<String>,
    onNewTimezoneClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        floatingActionButton = { NewTimezoneFloatingActionButton(onClick = onNewTimezoneClick) },
        floatingActionButtonPosition = FabPosition.Center,
    ) { innerPadding ->
        Text(
            modifier = Modifier.padding(innerPadding), text = "Hello"
        )
    }
}

@Preview
@Composable
private fun TimezonesScreenPreview() {
    TimezoneTrackerTheme {
        TimezonesScreen(
            savedTimezones = emptyList(),
            onNewTimezoneClick = { },
            modifier = Modifier,
        )
    }
}