package uk.co.mhl.timezonetracker.core.local

import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.isActive
import java.time.Instant

private const val TICK_INTERVAL_DELAY: Long = 1_000

class CurrentTimeDataSource : TimeDataSource {
    override fun getCurrentTime(): Flow<Instant> = flow {
        while (currentCoroutineContext().isActive) {
            emit(Instant.now())
            delay(TICK_INTERVAL_DELAY)
        }
    }
}