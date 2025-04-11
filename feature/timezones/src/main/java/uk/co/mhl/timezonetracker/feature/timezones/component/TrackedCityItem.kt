package uk.co.mhl.timezonetracker.feature.timezones.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.co.mhl.timezonetracker.core.designsystem.theme.TimeZoneTrackerTheme
import uk.co.mhl.timezonetracker.core.ui.zonedDateFormatted
import java.time.Instant
import java.time.ZoneId

@Composable
internal fun TrackedCityItem(
    modifier: Modifier = Modifier,
    currentTime: Instant,
    city: String,
    zoneId: String,
) {
    val zonedDateFormatted = zonedDateFormatted(currentTime, ZoneId.of(zoneId))

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = city,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = .75f)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = zonedDateFormatted,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onBackground,
            )
            // TODO: Uncomment when we know how to achieve an offset.
            // Text(
            //     text = "-5",
            //     style = MaterialTheme.typography.bodySmall,
            //     color = MaterialTheme.colorScheme.onBackground.copy(alpha = .5f)
            // )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TrackedCityItemPreview() {
    TimeZoneTrackerTheme {
        TrackedCityItem(
            currentTime = Instant.now(),
            city = "Toronto",
            zoneId = "America/Toronto",
        )
    }
}