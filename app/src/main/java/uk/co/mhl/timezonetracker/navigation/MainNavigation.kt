package uk.co.mhl.timezonetracker.navigation

import androidx.compose.animation.ContentTransform
import androidx.compose.animation.fadeIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import uk.co.mhl.timezonetracker.feature.addtimezone.navigation.addTimeZoneSection
import uk.co.mhl.timezonetracker.feature.addtimezone.navigation.navigateToAddTimeZone
import uk.co.mhl.timezonetracker.feature.timezones.TimeZonesScreen
import uk.co.mhl.timezonetracker.feature.timezones.navigation.TimeZonesBaseRoute
import uk.co.mhl.timezonetracker.feature.timezones.navigation.timeZonesSection

@Composable
fun MainNavigation() {

    //region Navigation Properties

    val backStack = remember { mutableStateListOf<NavigationRoute>(TimeZones) }

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
            entry<TimeZones> {
                TimeZonesScreen(
                    onNewTimeZoneClick = {
                        backStack.add(AddTimeZone)
                    }
                )
            }


//            timeZonesSection(
//                onNewTimeZoneClick = backStack::navigateToAddTimeZone,
//            ) {
//                addTimeZoneSection(
//                    onBack = backStack::removeLastOrNull,
//                    onCityTracked = backStack::removeLastOrNull,
//                )
//            }


        }
    )

    //endregion
}