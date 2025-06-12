package uk.co.mhl.timezonetracker.feature.timezones.navigation

import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entry
import kotlinx.serialization.Serializable
import uk.co.mhl.timezonetracker.feature.timezones.TimeZonesScreen

//region Route

@Serializable data object TimeZones : NavKey

//endregion

//region Graph

fun EntryProviderBuilder<NavKey>.timeZonesNavigation(onNewTimeZoneClick: () -> Unit) {
    entry<TimeZones> {
        TimeZonesScreen(onNewTimeZoneClick = onNewTimeZoneClick)
    }
}

//endregion