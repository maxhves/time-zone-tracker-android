package uk.co.mhl.timezonetracker.core.datastore

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Inject

class TimeZonePreferencesSerializer @Inject constructor() : Serializer<TimeZonePreferences> {
    override val defaultValue: TimeZonePreferences = TimeZonePreferences.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): TimeZonePreferences {
        return try {
            TimeZonePreferences.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(t: TimeZonePreferences, output: OutputStream) {
        t.writeTo(output)
    }
}