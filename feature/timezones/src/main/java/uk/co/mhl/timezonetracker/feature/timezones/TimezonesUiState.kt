package uk.co.mhl.timezonetracker.feature.timezones

import java.time.ZonedDateTime

data class TimezonesUiState(
    val currentTime: ZonedDateTime = ZonedDateTime.now(),
)