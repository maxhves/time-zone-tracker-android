package uk.co.mhl.timezones.core.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import uk.co.mhl.timezonetracker.core.local.TimeDataSource
import java.time.ZoneId
import java.time.ZonedDateTime
import javax.inject.Inject

internal class ZonedTimeRepository @Inject constructor(
    private val currentTimeDataSource: TimeDataSource,
) : TimeRepository {
    // TODO: Should this be zoned? Probably not since the flow should return a zone agnostic time,
    // TODO: and allow for the UI to adjust the time based on the saved zones.
    override fun getZonedCurrentTime(zoneId: ZoneId): Flow<ZonedDateTime> {
        return currentTimeDataSource.getCurrentTime().map { time ->
            time.atZone(zoneId)
        }
    }
}