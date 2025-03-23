package uk.co.mhl.timezonetracker.feature.timezones

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import uk.co.mhl.timezonetracker.core.designsystem.component.TimezoneTrackerTopAppBar
import uk.co.mhl.timezonetracker.core.designsystem.theme.TimezoneTrackerTheme
import uk.co.mhl.timezonetracker.feature.timezones.component.LocalTimeDisplay
import uk.co.mhl.timezonetracker.feature.timezones.component.NewTimezoneFloatingActionButton
import uk.co.mhl.timezonetracker.feature.timezones.component.SavedTimezoneItem
import java.time.Instant

@Composable
internal fun TimezonesScreen(
    onNewTimezoneClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: TimezonesViewModel = hiltViewModel(),
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()

    TimezonesScreen(
        currentTime = uiState.currentTime.epochSecond,
        savedTimezones = emptyList(),
        onNewTimezoneClick = onNewTimezoneClick,
        modifier = modifier,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TimezonesScreen(
    currentTime: Long,
    savedTimezones: List<String>,
    onNewTimezoneClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
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
            currentTime = Instant.now().epochSecond,
            savedTimezones = emptyList(),
            onNewTimezoneClick = { },
            modifier = Modifier,
        )
    }
}