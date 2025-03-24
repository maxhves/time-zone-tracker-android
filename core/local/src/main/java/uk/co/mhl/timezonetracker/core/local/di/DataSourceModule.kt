package uk.co.mhl.timezonetracker.core.local.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uk.co.mhl.timezonetracker.core.local.TimeTickBroadcastMonitor
import uk.co.mhl.timezonetracker.core.local.TimeTickMonitor

@Module
@InstallIn(SingletonComponent::class)
internal object DataSourceModule {
    @Provides
    fun providesCurrentTimeDataSource(@ApplicationContext context: Context): TimeTickMonitor =
        TimeTickBroadcastMonitor(context)
}