package uk.co.mhl.timezonetracker.core.data.repository

import kotlinx.coroutines.flow.Flow
import uk.co.mhl.timezonetracker.core.datastore.TimezoneTrackerPreferencesDataSource
import javax.inject.Inject

class OfflineFirstTimeZoneDataRepository @Inject constructor(
    private val timezoneTrackerPreferencesDataSource: TimezoneTrackerPreferencesDataSource
) : TimeZoneDataRepository {
    override fun observeTrackedZoneIds(): Flow<Set<Int>> {
        return timezoneTrackerPreferencesDataSource.observeTrackedZoneIds()
    }

    override suspend fun setZoneIdTracked(zoneId: Int, tracked: Boolean) {
        timezoneTrackerPreferencesDataSource.setZoneIdTracked(zoneId, tracked)
    }
}