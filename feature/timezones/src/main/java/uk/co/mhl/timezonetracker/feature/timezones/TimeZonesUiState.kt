package uk.co.mhl.timezonetracker.feature.timezones

import java.time.Instant

data class TimeZonesUiState(
    val currentTime: Instant = Instant.now(),
)