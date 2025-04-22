package uk.co.mhl.timezones.core.data.core.data.testdoubles

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import uk.co.mhl.timezonetracker.core.database.dao.CityDao
import uk.co.mhl.timezonetracker.core.database.model.LocalCity

class TestCityDao : CityDao {
    private val citiesStateFlow = MutableStateFlow(
        listOf(
            LocalCity(
                id = 1,
                name = "London",
                country = "England",
                zoneId = "Europe/London",
            ),
            LocalCity(
                id = 2,
                name = "Toronto",
                country = "Canada",
                zoneId = "America/Toronto",
            ),
            LocalCity(
                id = 3,
                name = "Auckland",
                country = "New Zealand",
                zoneId = "Pacific/Auckland"
            )
        )
    )

    override fun observeByIds(ids: Set<Int>): Flow<List<LocalCity>> {
        return citiesStateFlow.map { cities -> cities.filter { city -> city.id in ids } }
    }

    override suspend fun getAll(): List<LocalCity> {
        return citiesStateFlow.first()
    }

    override fun searchAllCities(query: String): Flow<List<LocalCity>> {
        val sanitizedQuery = query.replace("%", "")
        return citiesStateFlow.map { cities -> cities.filter { city ->
            "${city.name} ${city.country}".contains(sanitizedQuery, ignoreCase = true)
        }}
    }
}