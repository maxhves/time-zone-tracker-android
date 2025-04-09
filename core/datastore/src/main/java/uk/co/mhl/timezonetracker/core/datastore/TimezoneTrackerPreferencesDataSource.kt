package uk.co.mhl.timezonetracker.core.datastore

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TimezoneTrackerPreferencesDataSource @Inject constructor(
    private val timeZonePreferences: DataStore<TimeZonePreferences>,
) {
    //region Get

    fun observeTrackedZoneIds(): Flow<Set<Int>> {
        return timeZonePreferences.data.map { data -> data.trackedZoneIdsMap.keys }
    }

    //endregion

    //region Set

    suspend fun setZoneIdTracked(zoneId: Int, tracked: Boolean) {
        try {
            timeZonePreferences.updateData { data ->
                data.copy {
                    if (tracked) {
                        trackedZoneIds.put(zoneId, true)
                    } else {
                        trackedZoneIds.remove(zoneId)
                    }
                }
            }
        } catch (ioException: IOException) {
            Log.e(
                "TimeZoneTrackerPreferences",
                "Failed to update time zone preferences",
                ioException
            )
        }
    }

    //endregion
}