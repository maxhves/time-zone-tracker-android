package uk.co.mhl.timezonetracker.feature.timezones.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import uk.co.mhl.timezonetracker.feature.timezones.TimezonesScreen

//region Route

@Serializable data object TimezonesRoute
@Serializable data object TimezonesBaseRoute

//endregion

//region Graph

fun NavGraphBuilder.timezonesSection(
    onNewTimezoneClick: () -> Unit,
    addTimezoneDestination: NavGraphBuilder.() -> Unit,
) {
    navigation<TimezonesBaseRoute>(startDestination = TimezonesRoute) {
        composable<TimezonesRoute> {
            TimezonesScreen(
                onNewTimezoneClick = onNewTimezoneClick,
            )
        }
        addTimezoneDestination()
    }
}

//endregion