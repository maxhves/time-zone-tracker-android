package uk.co.mhl.timezonetracker.core.testing

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import uk.co.mhl.timezonetracker.core.data.repository.CityRepository
import uk.co.mhl.timezonetracker.core.data.util.groupByChar
import uk.co.mhl.timezonetracker.core.model.City

class TestCityRepository : CityRepository {

    private var citiesFlow: MutableSharedFlow<List<City>> = MutableSharedFlow(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )

    override fun observeByIds(ids: Set<Int>): Flow<List<City>> {
        return citiesFlow.map { cities -> cities.filter { it.id in ids } }
    }

    override suspend fun getAll(): List<City> {
        return citiesFlow.first()
    }

    override fun searchAllCities(query: String): Flow<Map<Char, List<City>>> {
        return citiesFlow
            .map { cities ->
                cities.filter { city ->
                    val searchString = "${city.name} ${city.country}".lowercase()
                    searchString.contains(query.lowercase())
                }
            }
            .map(List<City>::groupByChar)
    }

    fun sendCities(cities: List<City>) {
        citiesFlow.tryEmit(cities)
    }
}
