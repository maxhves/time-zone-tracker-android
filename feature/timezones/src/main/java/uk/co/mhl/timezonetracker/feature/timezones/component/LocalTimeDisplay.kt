package uk.co.mhl.timezonetracker.feature.timezones.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.co.mhl.timezonetracker.core.designsystem.theme.TimeZoneTrackerTheme
import uk.co.mhl.timezonetracker.core.ui.zonedDateFormatted
import uk.co.mhl.timezonetracker.feature.timezones.R
import java.time.Instant

@Composable
internal fun LocalTimeDisplay(
    modifier: Modifier = Modifier,
    currentTime: Instant,
) {
    val zonedDateFormatted =  zonedDateFormatted(currentTime)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceContainer)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = stringResource(R.string.local_time_display_label),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
        )
        Text(
            text = zonedDateFormatted,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
        )
    }
}

@Preview
@Composable
private fun LocalTimeDisplayPreview() {
    TimeZoneTrackerTheme {
        LocalTimeDisplay(
            currentTime = Instant.now(),
        )
    }
}