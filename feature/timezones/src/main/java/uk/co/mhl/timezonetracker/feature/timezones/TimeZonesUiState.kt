package uk.co.mhl.timezonetracker.feature.timezones

import uk.co.mhl.timezonetracker.core.model.City
import java.time.Instant

data class TimeZonesUiState(
    val currentTime: Instant = Instant.now(),
    val trackedCities: List<City> = emptyList(),
)