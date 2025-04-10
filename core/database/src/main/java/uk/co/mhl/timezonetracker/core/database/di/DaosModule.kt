package uk.co.mhl.timezonetracker.core.database.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uk.co.mhl.timezonetracker.core.database.TimeZoneTrackerDatabase
import uk.co.mhl.timezonetracker.core.database.dao.CityDao

@Module
@InstallIn(SingletonComponent::class)
internal object DaosModule {
    @Provides
    fun providesCityDao(
        database: TimeZoneTrackerDatabase
    ): CityDao = database.cityDao()
}