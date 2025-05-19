package uk.co.mhl.timezonetracker.core.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import uk.co.mhl.timezonetracker.core.data.util.groupByChar
import uk.co.mhl.timezonetracker.core.database.dao.CityDao
import uk.co.mhl.timezonetracker.core.database.model.LocalCity
import uk.co.mhl.timezonetracker.core.database.model.toExternal
import uk.co.mhl.timezonetracker.core.model.City
import javax.inject.Inject

class DefaultCityRepository @Inject constructor(
    private val cityDataSource: CityDao,
) : CityRepository {
    override fun observeByIds(ids: Set<Int>): Flow<List<City>> {
        return cityDataSource.observeByIds(ids).map(List<LocalCity>::toExternal)
    }

    override suspend fun getAll(): List<City> {
        return cityDataSource.getAll().map(LocalCity::toExternal)
    }

    override fun searchAllCities(query: String): Flow<Map<Char, List<City>>> {
        return cityDataSource.searchAllCities(query = "%${query}%")
            .map(List<LocalCity>::toExternal)
            .map(List<City>::groupByChar)
    }
}