package uk.co.mhl.timezonetracker.feature.addtimezone

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import uk.co.mhl.timezonetracker.core.designsystem.theme.TimezoneTrackerTheme
import uk.co.mhl.timezonetracker.core.model.City
import uk.co.mhl.timezonetracker.feature.addtimezone.component.AddTimezoneTopAppBar

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

@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalFoundationApi::class
)
@Composable
internal fun AddTimezoneScreen(
    cities: Map<Char, List<City>>,
    onCitySelected: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        topBar = { AddTimezoneTopAppBar(onCitySelected, scrollBehavior = scrollBehavior) },
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
        ) {
            cities.forEach { (character, citiesForChar) ->
                stickyHeader {
                    Box(
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.background)
                            .fillMaxWidth()
                            .padding(16.dp, 8.dp),
                    ) {
                        Text(
                            text = "$character",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.75f)
                        )
                    }
                }

                items(
                    items = citiesForChar,
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
}

@Preview
@Composable
private fun AddTimezoneScreenPreview() {
    TimezoneTrackerTheme {
        AddTimezoneScreen(
            cities = mapOf(
                'L' to listOf(City(id = 1, name = "London", country = "United Kingdom", zoneId = "Europe/London")),
                'O' to listOf(City(id = 2, name = "Oslo", country = "Norway", zoneId = "Europe/Oslo")),
                'T' to listOf(City(id = 3, name = "Toronto", country = "Canada", zoneId = "America/Toronto")),
            ),
            onCitySelected = { },
        )
    }
}