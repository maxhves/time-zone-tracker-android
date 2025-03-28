package uk.co.mhl.timezonetracker.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uk.co.mhl.timezonetracker.core.database.model.LocalCity

@Dao
interface CityDao {
    @Query("SELECT * FROM cities WHERE id IN (:ids)")
    fun observeByIds(ids: Set<Int>): Flow<List<LocalCity>>

    @Query("SELECT * FROM cities")
    suspend fun getAll(): List<LocalCity>
}