package uk.co.mhl.timezonetracker.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import uk.co.mhl.timezonetracker.feature.timezones.navigation.TimeZones
import uk.co.mhl.timezonetracker.feature.timezones.navigation.timeZonesNavigation
import uk.co.mhl.timezonetracker.feature.addtimezone.navigation.addTimeZonesNavigation
import uk.co.mhl.timezonetracker.feature.addtimezone.navigation.navigateToAddTimeZone

@Composable
fun MainNavigation() {

    //region Navigation Properties

    val backStack = rememberNavBackStack(TimeZones)

    //endregion

    //region Navigation Root

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryDecorators = listOf(
            rememberSavedStateNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            timeZonesNavigation(
                onNewTimeZoneClick = backStack::navigateToAddTimeZone,
            )
            addTimeZonesNavigation(
                onBack = backStack::removeLastOrNull,
                onCityTracked = backStack::removeLastOrNull,
            )
        }
    )

    //endregion
}