package uk.co.mhl.timezonetracker.core.data.repository

import kotlinx.coroutines.flow.Flow

interface UserDataRepository {
    fun observeTrackedCityIds(): Flow<Set<Int>>

    suspend fun setCityIdTracked(cityId: Int, tracked: Boolean)
}