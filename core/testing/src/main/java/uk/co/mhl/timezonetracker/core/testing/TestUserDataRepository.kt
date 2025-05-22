package uk.co.mhl.timezonetracker.core.testing

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.first
import uk.co.mhl.timezonetracker.core.data.repository.UserDataRepository

class TestUserDataRepository : UserDataRepository {

    private val trackedCityIds: MutableSharedFlow<MutableSet<Int>> = MutableSharedFlow(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )

    override fun observeTrackedCityIds(): Flow<Set<Int>> {
        return trackedCityIds
    }

    override suspend fun setCityIdTracked(cityId: Int, tracked: Boolean) {
        val current = trackedCityIds.first()

        if (tracked) {
            current.add(cityId)
        } else {
            current.remove(cityId)
        }

        trackedCityIds.tryEmit(current)
    }
}