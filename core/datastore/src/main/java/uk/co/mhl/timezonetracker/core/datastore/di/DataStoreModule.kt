package uk.co.mhl.timezonetracker.core.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import uk.co.mhl.timezonetracker.core.datastore.TimeZonePreferences
import uk.co.mhl.timezonetracker.core.datastore.TimeZonePreferencesSerializer
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    internal fun providesTimeZonePreferencesDataStore(
        @ApplicationContext context: Context,
        timeZonePreferencesSerializer: TimeZonePreferencesSerializer,
    ): DataStore<TimeZonePreferences> =
        DataStoreFactory.create(
            serializer = timeZonePreferencesSerializer,
            scope = CoroutineScope(CoroutineScope(Dispatchers.Default).coroutineContext + Dispatchers.IO),
        ) {
            context.dataStoreFile("time_zone_preferences.pb")
        }
}