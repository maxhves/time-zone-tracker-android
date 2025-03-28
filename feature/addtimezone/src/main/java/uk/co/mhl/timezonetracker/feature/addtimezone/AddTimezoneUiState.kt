package uk.co.mhl.timezonetracker.feature.addtimezone

import uk.co.mhl.timezonetracker.core.model.City

data class AddTimezoneUiState(
    val cities: List<City> = emptyList(),
)
