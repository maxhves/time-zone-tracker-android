package uk.co.mhl.timezonetracker.feature.timezones

import java.time.Instant

data class TimezonesUiState(
    val currentTime: Instant = Instant.now(),
)