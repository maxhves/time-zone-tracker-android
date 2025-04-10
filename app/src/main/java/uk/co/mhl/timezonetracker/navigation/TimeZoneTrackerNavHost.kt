package uk.co.mhl.timezonetracker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import uk.co.mhl.timezonetracker.feature.addtimezone.navigation.addTimeZoneSection
import uk.co.mhl.timezonetracker.feature.addtimezone.navigation.navigateToAddTimeZone
import uk.co.mhl.timezonetracker.feature.timezones.navigation.TimeZonesBaseRoute
import uk.co.mhl.timezonetracker.feature.timezones.navigation.timeZonesSection

@Composable
fun TimeZoneTrackerNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = TimeZonesBaseRoute,
        modifier = modifier,
    ) {
        timeZonesSection(
            onNewTimeZoneClick = navController::navigateToAddTimeZone
        ) {
            addTimeZoneSection(
                onBack = navController::popBackStack,
                onCityTracked = navController::popBackStack
            )
        }
    }
}