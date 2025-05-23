package uk.co.mhl.timezonetracker.core.data.repository

import kotlinx.coroutines.flow.Flow
import uk.co.mhl.timezonetracker.core.data.util.TimeTickMonitor
import java.time.Instant
import javax.inject.Inject

internal class CurrentTimeRepository @Inject constructor(
    private val timeTickMonitor: TimeTickMonitor,
) : TimeRepository {
    override fun getCurrentTime(): Flow<Instant> {
        return timeTickMonitor.currentTime()
    }
}