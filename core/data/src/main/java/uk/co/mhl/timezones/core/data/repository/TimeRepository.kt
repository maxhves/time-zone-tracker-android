package uk.co.mhl.timezones.core.data.repository

import kotlinx.coroutines.flow.Flow
import java.time.ZoneId
import java.time.ZonedDateTime

interface TimeRepository {
    fun getZonedCurrentTime(zoneId: ZoneId): Flow<ZonedDateTime>
}