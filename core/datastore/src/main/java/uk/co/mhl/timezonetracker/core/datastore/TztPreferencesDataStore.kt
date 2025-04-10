package uk.co.mhl.timezonetracker.core.datastore

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TztPreferencesDataStore @Inject constructor(
    private val userPreferences: DataStore<UserPreferences>,
) {
    //region Get

    fun observeTrackedCityIds(): Flow<Set<Int>> {
        return userPreferences.data.map { data -> data.trackedCityIdsMap.keys }
    }

    //endregion

    //region Set

    suspend fun setCityIdTracked(cityId: Int, tracked: Boolean) {
        try {
            userPreferences.updateData { data ->
                data.copy {
                    if (tracked) {
                        trackedCityIds.put(cityId, true)
                    } else {
                        trackedCityIds.remove(cityId)
                    }
                }
            }
        } catch (ioException: IOException) {
            Log.e(
                "TimeZoneTrackerPreferences",
                "Failed to update user preferences",
                ioException
            )
        }
    }

    //endregion
}