package uk.co.mhl.timezonetracker.feature.addtimezone.navigation

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import uk.co.mhl.timezonetracker.feature.addtimezone.AddTimeZoneScreen

//region Route

@Serializable data object AddTimeZoneRoute

//endregion

//region Navigation

fun NavController.navigateToAddTimeZone(navOptions: NavOptionsBuilder.() -> Unit = {}) {
    navigate(route = AddTimeZoneRoute) {
        navOptions()
    }
}

fun SnapshotStateList<Any>.navigateToAddTimeZone() {
    add(AddTimeZoneRoute)
}

//endregion

//region Graph

fun NavGraphBuilder.addTimeZoneSection(
    onBack: () -> Unit,
    onCityTracked: () -> Unit,
) {
    composable<AddTimeZoneRoute> {
        AddTimeZoneScreen(
            onBack = onBack,
            onCityTracked = onCityTracked,
        )
    }
}

//endregion