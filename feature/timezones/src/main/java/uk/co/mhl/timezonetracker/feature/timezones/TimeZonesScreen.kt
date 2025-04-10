package uk.co.mhl.timezonetracker.feature.timezones

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import uk.co.mhl.timezonetracker.core.designsystem.component.TimeZoneTrackerTopAppBar
import uk.co.mhl.timezonetracker.core.designsystem.theme.TimeZoneTrackerTheme
import uk.co.mhl.timezonetracker.core.model.City
import uk.co.mhl.timezonetracker.feature.timezones.component.LocalTimeDisplay
import uk.co.mhl.timezonetracker.feature.timezones.component.NewTimeZoneFloatingActionButton
import uk.co.mhl.timezonetracker.feature.timezones.component.SavedTimeZoneItem
import java.time.Instant

@Composable
internal fun TimeZonesScreen(
    onNewTimeZoneClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: TimeZonesViewModel = hiltViewModel(),
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()

    TimeZonesScreen(
        currentTime = uiState.currentTime,
        trackedCities = uiState.trackedCities,
        onNewTimeZoneClick = onNewTimeZoneClick,
        modifier = modifier,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TimeZonesScreen(
    currentTime: Instant,
    trackedCities: List<City>,
    onNewTimeZoneClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TimeZoneTrackerTopAppBar(titleRes = R.string.timezones_screen_title)
        },
        floatingActionButton = { NewTimeZoneFloatingActionButton(onClick = onNewTimeZoneClick) },
        floatingActionButtonPosition = FabPosition.Center,
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
        ) {
            // TODO: Properly show SavedTimeZoneItems.
            LocalTimeDisplay(currentTime = currentTime)
            LazyColumn {
                items(trackedCities) { city ->
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = city.name
                    )
                }
            }
//            SavedTimeZoneItem(
//                cityName = "Toronto",
//                offset = -5,
//                currentTime = currentTime,
//            )
        }
    }
}

@Preview
@Composable
private fun TimeZonesScreenPreview() {
    TimeZoneTrackerTheme {
        TimeZonesScreen(
            currentTime = Instant.now(),
            trackedCities = listOf(
                City(
                    id = 0,
                    name = "Toronto",
                    country = "Canada",
                    zoneId = "America/Toronto",
                )
            ),
            onNewTimeZoneClick = { },
        )
    }
}