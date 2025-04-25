package uk.co.mhl.timezonetracker.core

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import uk.co.mhl.timezonetracker.core.datastore.TztPreferencesDataStore
import uk.co.mhl.timezonetracker.core.datastore.UserPreferences
import kotlin.test.assertEquals

class TztPreferencesDataStoreTest {

    private val testScope = TestScope(UnconfinedTestDispatcher())

    private lateinit var subject: TztPreferencesDataStore

    @Before
    fun setup() {
        subject = TztPreferencesDataStore(InMemoryDataStore(UserPreferences.getDefaultInstance()))
    }

    @Test
    fun cityIdIsPresentWhenSetTrackedIsTrue() = testScope.runTest {
        subject.setCityIdTracked(cityId = 88, tracked = true)
        val trackedCityIds = subject.observeTrackedCityIds().first()

        assertEquals(setOf(88), trackedCityIds)
    }

    @Test
    fun cityIdIsNotPresentWhenSetTrackedIsFalse() = testScope.runTest {
        subject.setCityIdTracked(cityId = 88, tracked = true)
        subject.setCityIdTracked(cityId = 88, tracked = false)
        val trackedCityIds = subject.observeTrackedCityIds().first()

        assertEquals(emptySet(), trackedCityIds)
    }
}