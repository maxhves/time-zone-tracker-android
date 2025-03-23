package uk.co.mhl.timezones.core.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import uk.co.mhl.timezonetracker.core.local.CurrentTimeDataSource
import java.time.ZoneId
import java.time.ZonedDateTime

internal class ZonedTimeRepository(
    private val currentTimeDataSource: CurrentTimeDataSource,
) : TimeRepository {
    override fun getZonedCurrentTime(zoneId: ZoneId): Flow<ZonedDateTime> {
        return currentTimeDataSource.getCurrentTime().map { time ->
            time.atZone(zoneId)
        }
    }
}