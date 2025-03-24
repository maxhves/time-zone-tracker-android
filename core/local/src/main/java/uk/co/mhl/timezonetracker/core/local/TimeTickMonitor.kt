package uk.co.mhl.timezonetracker.core.local

import kotlinx.coroutines.flow.Flow
import java.time.Instant

interface TimeTickMonitor {
    fun currentTime(): Flow<Instant>
}