package uk.co.mhl.timezonetracker.core.database.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import org.junit.After
import org.junit.Before
import uk.co.mhl.timezonetracker.core.database.TimeZoneTrackerDatabase

internal abstract class DatabaseTest {

    private lateinit var database: TimeZoneTrackerDatabase
    protected lateinit var cityDao: CityDao

    @Before
    fun setup() {
        database = run {
            val context = ApplicationProvider.getApplicationContext<Context>()

            Room.databaseBuilder(
                context,
                TimeZoneTrackerDatabase::class.java,
                "test-timezone-tracker-database"
            )
                .createFromAsset("city_timezone.db")
                .build()
        }
        cityDao = database.cityDao()
    }

    @After
    fun teardown() {
        database.close()
    }
}