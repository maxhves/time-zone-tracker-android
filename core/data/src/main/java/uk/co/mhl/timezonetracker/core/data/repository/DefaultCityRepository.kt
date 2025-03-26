package uk.co.mhl.timezonetracker.core.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import uk.co.mhl.timezonetracker.core.database.dao.CityDao
import uk.co.mhl.timezonetracker.core.database.model.LocalCity
import uk.co.mhl.timezonetracker.core.database.model.toExternal
import javax.inject.Inject

class DefaultCityRepository @Inject constructor(
    private val cityDataSource: CityDao,
) : CityRepository {
    override fun observeAll(): Flow<List<String>> {
        return cityDataSource.observeAll().map(List<LocalCity>::toExternal)
    }
}