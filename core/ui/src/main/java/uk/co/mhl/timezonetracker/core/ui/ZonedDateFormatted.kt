package uk.co.mhl.timezonetracker.core.ui

import androidx.compose.runtime.Composable
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.Locale

@Composable
fun zonedDateFormatted(
    currentTime: Instant,
    zoneId: ZoneId = ZoneId.systemDefault()
): String {
    return DateTimeFormatter
        .ofLocalizedTime(FormatStyle.SHORT)
        .withLocale(Locale.getDefault())
        .withZone(zoneId)
        .format(currentTime)
}