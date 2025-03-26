package uk.co.mhl.timezonetracker.feature.addtimezone.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable

//region Route

@Serializable data object AddTimezoneRoute
@Serializable data object AddTimezoneBaseRoute

//endregion

//region Graph

fun NavGraphBuilder.addTimezoneSection(
    onTimezoneSelected: () -> Unit,
) {
    navigation<AddTimezoneBaseRoute>(startDestination = AddTimezoneRoute) {
        composable<AddTimezoneRoute> {
            // TODO: Include AddTimezoneScreen here.
        }
    }
}

//endregion