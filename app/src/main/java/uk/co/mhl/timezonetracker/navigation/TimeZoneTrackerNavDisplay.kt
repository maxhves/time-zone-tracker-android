package uk.co.mhl.timezonetracker.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import uk.co.mhl.timezonetracker.feature.addtimezone.navigation.AddTimeZoneRoute
import uk.co.mhl.timezonetracker.feature.addtimezone.navigation.navigateToAddTimeZone
import uk.co.mhl.timezonetracker.feature.timezones.navigation.TimeZonesBaseRoute
import uk.co.mhl.timezonetracker.feature.timezones.navigation.timeZonesSection

@Composable
fun TimeZoneTrackerNavDisplay() {

    //region Back Stack

    val backStack = remember { mutableStateListOf<Any>(TimeZonesBaseRoute) }

    //endregion

    //region Navigation Root

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            timeZonesSection(
                onNewTimeZoneClick = backStack::navigateToAddTimeZone,
            ) {
                entry<AddTimeZoneRoute> {
                    Text("hello")
                }
            }
        }
    )

    //endregion
}