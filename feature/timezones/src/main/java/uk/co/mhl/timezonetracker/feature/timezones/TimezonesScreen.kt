package uk.co.mhl.timezonetracker.feature.timezones

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uk.co.mhl.timezonetracker.core.designsystem.component.TimezoneTrackerTopAppBar
import uk.co.mhl.timezonetracker.core.designsystem.theme.TimezoneTrackerTheme
import uk.co.mhl.timezonetracker.feature.timezones.component.LocalTimeDisplay
import uk.co.mhl.timezonetracker.feature.timezones.component.NewTimezoneFloatingActionButton
import uk.co.mhl.timezonetracker.feature.timezones.component.SavedTimezoneItem

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TimezonesScreen(
    savedTimezones: List<String>,
    onNewTimezoneClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val currentTime = remember { System.currentTimeMillis() }

    Scaffold(
        modifier = modifier,
        topBar = {
            TimezoneTrackerTopAppBar(
                titleRes = R.string.timezones_screen_title,
            )
        },
        floatingActionButton = { NewTimezoneFloatingActionButton(onClick = onNewTimezoneClick) },
        floatingActionButtonPosition = FabPosition.Center,
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
        ) {
            LocalTimeDisplay(currentTime = currentTime)
            SavedTimezoneItem(
                cityName = "Toronto",
                offset = -5,
                currentTime = currentTime,
            )
        }
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