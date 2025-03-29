package uk.co.mhl.timezonetracker.feature.addtimezone

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import uk.co.mhl.timezonetracker.core.designsystem.theme.TimezoneTrackerTheme
import uk.co.mhl.timezonetracker.core.model.City

@Composable
internal fun AddTimezoneScreen(
    onCitySelected: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AddTimezoneViewModel = hiltViewModel(),
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()

    AddTimezoneScreen(
        cities = uiState.cities,
        onCitySelected = onCitySelected,
        modifier = modifier,
    )
}

@Composable
internal fun AddTimezoneScreen(
    cities: List<City>,
    onCitySelected: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
    ) { innerPadding ->
        LazyColumn(
            modifier = modifier.padding(innerPadding),
        ) {
            items(
                items = cities,
                key = { city -> city.id }
            ) { city ->
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(onClick = onCitySelected)
                        .padding(16.dp),
                    text = "${city.name}, ${city.country}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}

@Preview
@Composable
private fun AddTimezoneScreenPreview() {
    TimezoneTrackerTheme {
        AddTimezoneScreen(
            cities = listOf(
                City(id = 1, name = "Toronto", country = "Canada", zoneId = "America/Toronto"),
                City(id = 2, name = "Oslo", country = "Norway", zoneId = "Europe/Oslo"),
            ),
            onCitySelected = { },
        )
    }
}