package uk.co.mhl.timezonetracker.feature.timezones.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation3.runtime.EntryProvider
import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.entry
import kotlinx.serialization.Serializable
import uk.co.mhl.timezonetracker.feature.timezones.TimeZonesScreen

//region Route

@Serializable data object TimeZonesRoute
@Serializable data object TimeZonesBaseRoute

//endregion

//region Graph

fun NavGraphBuilder.timeZonesSection(
    onNewTimeZoneClick: () -> Unit,
    addTimeZoneDestination: NavGraphBuilder.() -> Unit,
) {
    navigation<TimeZonesBaseRoute>(startDestination = TimeZonesRoute) {
        composable<TimeZonesRoute> {
            TimeZonesScreen(
                onNewTimeZoneClick = onNewTimeZoneClick,
            )
        }
        addTimeZoneDestination()
    }
}


fun EntryProviderBuilder<*>.timeZonesSection(
    onNewTimeZoneClick: () -> Unit,
    addTimeZoneDestination: EntryProviderBuilder<*>.() -> Unit,
) {
    entry<TimeZonesBaseRoute> {
        TimeZonesScreen(
            onNewTimeZoneClick = onNewTimeZoneClick,
        )
    }
    addTimeZoneDestination()
}

//endregion