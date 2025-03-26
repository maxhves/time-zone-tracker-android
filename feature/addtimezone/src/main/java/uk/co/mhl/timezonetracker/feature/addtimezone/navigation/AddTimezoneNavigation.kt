package uk.co.mhl.timezonetracker.feature.addtimezone.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import uk.co.mhl.timezonetracker.feature.addtimezone.AddTimezoneScreen

//region Route

@Serializable data object AddTimezoneRoute
@Serializable data object AddTimezoneBaseRoute

//endregion

//region Graph

fun NavGraphBuilder.addTimezoneSection(
    onCitySelected: () -> Unit,
) {
    navigation<AddTimezoneBaseRoute>(startDestination = AddTimezoneRoute) {
        composable<AddTimezoneRoute> {
            AddTimezoneScreen(
                onCitySelected = onCitySelected,
            )
        }
    }
}

//endregion