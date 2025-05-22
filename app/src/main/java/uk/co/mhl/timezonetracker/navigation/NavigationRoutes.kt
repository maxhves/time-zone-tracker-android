package uk.co.mhl.timezonetracker.navigation

import kotlinx.serialization.Serializable

interface NavigationRoute

//region Home

@Serializable
data object TimeZones : NavigationRoute

@Serializable
data object AddTimeZone : NavigationRoute

//endregion