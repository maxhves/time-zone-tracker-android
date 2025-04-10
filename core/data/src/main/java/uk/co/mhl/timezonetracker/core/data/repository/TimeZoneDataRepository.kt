package uk.co.mhl.timezonetracker.core.data.repository

import kotlinx.coroutines.flow.Flow

interface TimeZoneDataRepository {
    fun observeTrackedZoneIds(): Flow<Set<Int>>

    suspend fun setZoneIdTracked(zoneId: Int, tracked: Boolean)
}