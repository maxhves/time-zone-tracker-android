package uk.co.mhl.timezonetracker.core.data.util

import kotlinx.coroutines.flow.Flow
import java.time.Instant

interface TimeTickMonitor {
    fun currentTime(): Flow<Instant>
}