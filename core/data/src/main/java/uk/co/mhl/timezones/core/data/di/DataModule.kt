package uk.co.mhl.timezones.core.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uk.co.mhl.timezones.core.data.repository.TimeRepository
import uk.co.mhl.timezones.core.data.repository.ZonedTimeRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    internal abstract fun bindsTimeRepository(
        zonedTimeRepository: ZonedTimeRepository
    ): TimeRepository
}