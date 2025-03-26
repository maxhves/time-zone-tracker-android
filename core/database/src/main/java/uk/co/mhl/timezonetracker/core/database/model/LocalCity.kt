package uk.co.mhl.timezonetracker.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cities")
data class LocalCity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val country: String,
    val zoneId: String,
)

// TODO: Implement proper toExternal mapping for the external model.
fun LocalCity.toExternal(): String {
    return name
}

fun List<LocalCity>.toExternal(): List<String> {
    return map(LocalCity::toExternal)
}