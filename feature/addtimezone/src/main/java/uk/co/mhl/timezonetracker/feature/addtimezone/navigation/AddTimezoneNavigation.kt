package uk.co.mhl.timezonetracker.feature.addtimezone.navigation

import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entry
import kotlinx.serialization.Serializable
import uk.co.mhl.timezonetracker.feature.addtimezone.AddTimeZoneScreen

//region Route

@Serializable data object AddTimeZone : NavKey

//endregion

//region Events

fun NavBackStack.navigateToAddTimeZone() {
    add(AddTimeZone)
}

//endregion

//region Graph

fun EntryProviderBuilder<NavKey>.addTimeZonesNavigation(
    onBack: () -> Unit,
    onCityTracked: () -> Unit,
) {
    entry<AddTimeZone> {
        AddTimeZoneScreen(
            onBack = onBack,
            onCityTracked = onCityTracked,
        )
    }
}

//endregion