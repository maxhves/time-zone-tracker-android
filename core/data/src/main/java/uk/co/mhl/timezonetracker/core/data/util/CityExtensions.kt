package uk.co.mhl.timezonetracker.core.data.util

import uk.co.mhl.timezonetracker.core.model.City

fun List<City>.groupByChar(): Map<Char, List<City>> {
    return groupBy { it.name.first().uppercaseChar() }
}
