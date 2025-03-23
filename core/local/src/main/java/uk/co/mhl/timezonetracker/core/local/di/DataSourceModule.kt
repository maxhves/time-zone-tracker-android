package uk.co.mhl.timezonetracker.core.local.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uk.co.mhl.timezonetracker.core.local.CurrentTimeDataSource
import uk.co.mhl.timezonetracker.core.local.TimeDataSource

@Module
@InstallIn(SingletonComponent::class)
internal object DataSourceModule{
    @Provides
    fun providesCurrentTimeDataSource(): TimeDataSource = CurrentTimeDataSource()
}