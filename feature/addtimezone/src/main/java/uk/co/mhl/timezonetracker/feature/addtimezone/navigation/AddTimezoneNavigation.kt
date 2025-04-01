package uk.co.mhl.timezonetracker.feature.addtimezone.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import uk.co.mhl.timezonetracker.feature.addtimezone.AddTimezoneScreen

//region Route

@Serializable data object AddTimezoneRoute

//endregion

//region Navigation

fun NavController.navigateToAddTimezone(navOptions: NavOptionsBuilder.() -> Unit = {}) {
    navigate(route = AddTimezoneRoute) {
        navOptions()
    }
}

//endregion

//region Graph

fun NavGraphBuilder.addTimezoneSection(
    onBack: () -> Unit,
    onCityClick: () -> Unit,
) {
    composable<AddTimezoneRoute> {
        AddTimezoneScreen(
            onBack = onBack,
            onCityClick = onCityClick,
        )
    }
}

//endregion