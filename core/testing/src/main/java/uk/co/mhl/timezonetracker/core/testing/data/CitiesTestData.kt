package uk.co.mhl.timezonetracker.core.testing.data

import uk.co.mhl.timezonetracker.core.model.City

val citiesTestData: List<City> = listOf(
    City(
        id = 37,
        name = "Auckland",
        country = "New Zealand",
        zoneId = "Pacific/Auckland"
    ),
    City(
        id = 265,
        name = "London",
        country = "United Kingdom",
        zoneId = "Europe/London",
    ),
    City(
        id = 369,
        name = "Oslo",
        country = "Norway",
        zoneId = "Europe/Oslo",
    ),
    City(
        id = 521,
        name = "Toronto",
        country = "Canada",
        zoneId = "America/Toronto",
    ),
)