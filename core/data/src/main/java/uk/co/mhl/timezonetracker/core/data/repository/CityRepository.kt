package uk.co.mhl.timezonetracker.core.data.repository

import kotlinx.coroutines.flow.Flow
import uk.co.mhl.timezonetracker.core.model.City

interface CityRepository {
    fun observeAll(): Flow<List<City>>

    fun observeByIds(ids: Set<Int>): Flow<List<City>>
}