package uk.co.mhl.timezonetracker.core.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uk.co.mhl.timezonetracker.core.data.repository.TimeRepository
import uk.co.mhl.timezonetracker.core.data.repository.CurrentTimeRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    internal abstract fun bindsTimeRepository(
        currentTimeRepository: CurrentTimeRepository
    ): TimeRepository
}