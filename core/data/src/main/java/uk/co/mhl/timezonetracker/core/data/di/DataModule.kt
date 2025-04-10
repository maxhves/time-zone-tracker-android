package uk.co.mhl.timezonetracker.core.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uk.co.mhl.timezonetracker.core.data.repository.CityRepository
import uk.co.mhl.timezonetracker.core.data.repository.CurrentTimeRepository
import uk.co.mhl.timezonetracker.core.data.repository.DefaultCityRepository
import uk.co.mhl.timezonetracker.core.data.repository.OfflineFirstUserDataRepository
import uk.co.mhl.timezonetracker.core.data.repository.TimeRepository
import uk.co.mhl.timezonetracker.core.data.repository.UserDataRepository
import uk.co.mhl.timezonetracker.core.data.util.TimeTickBroadcastMonitor
import uk.co.mhl.timezonetracker.core.data.util.TimeTickMonitor

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    internal abstract fun bindsTimeRepository(
        currentTimeRepository: CurrentTimeRepository
    ): TimeRepository

    @Binds
    internal abstract fun bindsTimeTickMonitor(
        timeTickBroadcastMonitor: TimeTickBroadcastMonitor
    ): TimeTickMonitor

    @Binds
    internal abstract fun bindsCityRepository(
        defaultCityRepository: DefaultCityRepository
    ): CityRepository

    @Binds
    internal abstract fun bindsUserDataRepository(
        offlineFirstUserDataRepository: OfflineFirstUserDataRepository,
    ): UserDataRepository
}