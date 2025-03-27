package uk.co.mhl.timezonetracker.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import uk.co.mhl.timezonetracker.core.model.City

@Entity(tableName = "cities")
data class LocalCity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val country: String,
    val zoneId: String,
)

fun LocalCity.toExternal(): City {
    return City(
        id = id,
        name = name,
        country = country,
        zoneId = zoneId,
    )
}

fun List<LocalCity>.toExternal(): List<City> {
    return map(LocalCity::toExternal)
}