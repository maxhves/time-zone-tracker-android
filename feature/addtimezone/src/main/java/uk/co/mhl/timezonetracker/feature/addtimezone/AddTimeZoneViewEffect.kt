package uk.co.mhl.timezonetracker.feature.addtimezone

sealed class AddTimeZoneViewEffect

data object OnCityTracked : AddTimeZoneViewEffect()