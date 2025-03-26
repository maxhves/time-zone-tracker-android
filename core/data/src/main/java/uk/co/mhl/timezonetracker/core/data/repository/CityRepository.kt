package uk.co.mhl.timezonetracker.core.data.repository

import kotlinx.coroutines.flow.Flow

interface CityRepository {
    fun observeAll(): Flow<List<String>>
}