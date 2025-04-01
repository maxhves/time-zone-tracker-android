package uk.co.mhl.timezonetracker.feature.addtimezone

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
    onCityClick: () -> Unit,
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AddTimezoneViewModel = hiltViewModel(),
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()

    AddTimezoneScreen(
        searchQuery = uiState.searchQuery,
        onSearchQueryChange = viewModel::onSearchQueryChange,
        cities = uiState.cities,
        onCityClick = onCityClick,
        onBack = onBack,
        modifier = modifier,
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
internal fun AddTimezoneScreen(
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    cities: Map<Char, List<City>>,
    onCityClick: () -> Unit,
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        topBar = {
            AddTimezoneTopAppBar(
                searchQuery = searchQuery,
                onSearchQueryChange = onSearchQueryChange,
                onNavigateClick = onBack,
                scrollBehavior = scrollBehavior
            )
        },
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
        ) {
            cities.forEach { (character, citiesForCharacter) ->
                if (searchQuery.isBlank()) {
                    stickyHeader {
                        Text(
                            modifier = Modifier
                                .background(MaterialTheme.colorScheme.background)
                                .fillMaxWidth()
                                .padding(16.dp, 8.dp),
                            text = "$character",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.75f)
                        )
                    }
                }

                items(
                    items = citiesForCharacter,
                    key = { city -> city.id }
                ) { city ->
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(onClick = onCityClick)
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
            searchQuery = "",
            onSearchQueryChange = { },
            cities = mapOf(
                'L' to listOf(
                    City(
                        id = 1,
                        name = "London",
                        country = "United Kingdom",
                        zoneId = "Europe/London"
                    )
                ),
                'O' to listOf(
                    City(
                        id = 2,
                        name = "Oslo",
                        country = "Norway",
                        zoneId = "Europe/Oslo"
                    )
                ),
                'T' to listOf(
                    City(
                        id = 3,
                        name = "Toronto",
                        country = "Canada",
                        zoneId = "America/Toronto"
                    )
                ),
            ),
            onBack = { },
            onCityClick = { },
        )
    }
}