package uk.co.mhl.timezonetracker.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import uk.co.mhl.timezonetracker.core.database.dao.CityDao
import uk.co.mhl.timezonetracker.core.database.model.LocalCity

@Database(
    entities = [LocalCity::class],
    version = 1,
    exportSchema = true
)
internal abstract class TimezoneTrackerDatabase : RoomDatabase() {
    abstract fun cityDao(): CityDao
}