package uk.co.mhl.timezonetracker.core.database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uk.co.mhl.timezonetracker.core.database.TimezoneTrackerDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {
    @Provides
    @Singleton
    fun providesTimezoneTrackerDatabase(
        @ApplicationContext context: Context
    ): TimezoneTrackerDatabase = Room.databaseBuilder(
        context,
        TimezoneTrackerDatabase::class.java,
        "timezonetracker-database"
    ).build()
}