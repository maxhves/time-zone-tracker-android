package uk.co.mhl.timezonetracker.core.data.repository

import kotlinx.coroutines.flow.Flow
import java.time.Instant

interface TimeRepository {
    fun getCurrentTime(): Flow<Instant>
}