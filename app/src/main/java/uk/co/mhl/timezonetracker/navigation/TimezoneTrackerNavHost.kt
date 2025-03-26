package uk.co.mhl.timezonetracker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import uk.co.mhl.timezonetracker.feature.addtimezone.navigation.addTimezoneSection
import uk.co.mhl.timezonetracker.feature.addtimezone.navigation.navigateToAddTimezone
import uk.co.mhl.timezonetracker.feature.timezones.navigation.TimezonesBaseRoute
import uk.co.mhl.timezonetracker.feature.timezones.navigation.timezonesSection

@Composable
fun TimezoneTrackerNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = TimezonesBaseRoute,
        modifier = modifier,
    ) {
        timezonesSection(
            onNewTimezoneClick = navController::navigateToAddTimezone
        ) {
            addTimezoneSection(
                onCitySelected = navController::popBackStack
            )
        }
    }
}