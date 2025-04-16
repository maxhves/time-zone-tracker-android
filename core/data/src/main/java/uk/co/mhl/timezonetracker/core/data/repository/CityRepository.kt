package uk.co.mhl.timezonetracker.core.data.repository

import kotlinx.coroutines.flow.Flow
import uk.co.mhl.timezonetracker.core.model.City

interface CityRepository {
    fun observeByIds(ids: Set<Int>): Flow<List<City>>

    suspend fun getAll(): List<City>

    fun searchAllCities(query: String): Flow<Map<Char, List<City>>>
}