package uk.co.mhl.timezones.core.data.core.data.repository

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import uk.co.mhl.timezones.core.data.core.data.testdoubles.TestCityDao
import uk.co.mhl.timezonetracker.core.data.repository.DefaultCityRepository
import uk.co.mhl.timezonetracker.core.database.dao.CityDao
import kotlin.test.assertEquals

class DefaultCityRepositoryTest {

    private val testScope = TestScope(UnconfinedTestDispatcher())

    private lateinit var subject: DefaultCityRepository

    private lateinit var cityDao: CityDao

    @Before
    fun setup() {
        cityDao = TestCityDao()

        subject = DefaultCityRepository(
            cityDataSource = cityDao,
        )
    }

    @Test
    fun defaultCityRepository_observe_ids_returns_correct_cities() = testScope.runTest {
        val cities = subject.observeByIds(setOf(2)).first()

        assertEquals(
            listOf(2),
            cities.map { city -> city.id }
        )
    }

    @Test
    fun defaultCityRepository_get_all_returns_all_cities() = testScope.runTest {
        val cities = subject.getAll()

        assertEquals(3, cities.count())
    }

    @Test
    fun defaultCityRepository_search_all_cities_returns_correct_cities() = testScope.runTest {
        val cities = subject.searchAllCities("england").first()

        assertEquals(1, cities.count())
    }
}
