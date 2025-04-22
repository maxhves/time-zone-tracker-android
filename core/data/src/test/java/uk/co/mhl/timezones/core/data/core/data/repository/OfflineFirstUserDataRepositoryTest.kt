package uk.co.mhl.timezones.core.data.core.data.repository

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import uk.co.mhl.timezones.core.data.core.data.InMemoryDataStore
import uk.co.mhl.timezonetracker.core.data.repository.OfflineFirstUserDataRepository
import uk.co.mhl.timezonetracker.core.datastore.TztPreferencesDataStore
import uk.co.mhl.timezonetracker.core.datastore.UserPreferences
import kotlin.test.assertEquals

class OfflineFirstUserDataRepositoryTest {

    private val testScope = TestScope(UnconfinedTestDispatcher())

    private lateinit var subject: OfflineFirstUserDataRepository

    private lateinit var tztPreferencesDataStore: TztPreferencesDataStore

    @Before
    fun setup() {
        tztPreferencesDataStore = TztPreferencesDataStore(
            userPreferences = InMemoryDataStore(UserPreferences.getDefaultInstance())
        )

        subject = OfflineFirstUserDataRepository(
            tztPreferencesDataStore = tztPreferencesDataStore
        )
    }

    @Test
    fun offlineFirstUserDataRepository_observe_tracked_ids_returns_correct_ids() = testScope.runTest {
        tztPreferencesDataStore.setCityIdTracked(1, true)
        val trackedIds = tztPreferencesDataStore.observeTrackedCityIds().first()

        assertEquals(setOf(1), trackedIds)
    }

    @Test
    fun offlineFirstUserDataRepository_set_tracked_true_stores_id() = testScope.runTest {
        tztPreferencesDataStore.setCityIdTracked(1, true)
        tztPreferencesDataStore.setCityIdTracked(2, true)
        tztPreferencesDataStore.setCityIdTracked(3, true)
        tztPreferencesDataStore.setCityIdTracked(2, false)
        val trackedIds = tztPreferencesDataStore.observeTrackedCityIds().first()

        assertEquals(setOf(1, 3), trackedIds)
    }
}