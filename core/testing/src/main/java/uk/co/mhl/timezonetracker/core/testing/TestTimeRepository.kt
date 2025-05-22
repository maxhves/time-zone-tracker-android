package uk.co.mhl.timezonetracker.core.testing

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import uk.co.mhl.timezonetracker.core.data.repository.TimeRepository
import java.time.Instant

class TestTimeRepository : TimeRepository {

    private val timeFlow: MutableSharedFlow<Instant> = MutableSharedFlow(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )

    override fun getCurrentTime(): Flow<Instant> {
        return timeFlow
    }

    fun sendTime(instant: Instant) {
        timeFlow.tryEmit(instant)
    }
}