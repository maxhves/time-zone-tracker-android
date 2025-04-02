package uk.co.mhl.timezonetracker.core.database.dao

import uk.co.mhl.timezonetracker.core.database.TimezoneTrackerDatabase

internal abstract class DatabaseTest {

    private lateinit var database: TimezoneTrackerDatabase
    private lateinit var cityDao: CityDao
}