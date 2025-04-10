package uk.co.mhl.timezonetracker.feature.addtimezone

import uk.co.mhl.timezonetracker.core.model.City

data class AddTimeZoneUiState(
    val searchQuery: String = "",
    val cities: Map<Char, List<City>> = mapOf(),
)
