package uk.co.mhl.timezonetracker.core.data.repository

import kotlinx.coroutines.flow.Flow
import uk.co.mhl.timezonetracker.core.datastore.TztPreferencesDataStore
import javax.inject.Inject

class OfflineFirstUserDataRepository @Inject constructor(
    private val tztPreferencesDataStore: TztPreferencesDataStore
) : UserDataRepository {
    override fun observeTrackedCityIds(): Flow<Set<Int>> {
        return tztPreferencesDataStore.observeTrackedCityIds()
    }

    override suspend fun setCityIdTracked(cityId: Int, tracked: Boolean) {
        tztPreferencesDataStore.setCityIdTracked(cityId, tracked)
    }
}