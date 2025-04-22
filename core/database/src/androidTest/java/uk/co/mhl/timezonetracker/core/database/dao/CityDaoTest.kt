package uk.co.mhl.timezonetracker.core.database.dao

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

internal class CityDaoTest : DatabaseTest() {

    @Test
    fun getCitiesByIds() = runTest {
        val cities = cityDao.observeByIds(setOf(1, 22, 333)).first()

        assertEquals(
            listOf(1, 22, 333),
            cities.map { it.id }
        )
    }

    @Test
    fun getCities_oneOff() = runTest {
        val cities = cityDao.getAll()

        assertEquals(567, cities.count())
    }

    @Test
    fun searchCitiesByQuery() = runTest {
        val cities = cityDao.searchAllCities("%london%").first()

        assertEquals(1, cities.count())
    }
}