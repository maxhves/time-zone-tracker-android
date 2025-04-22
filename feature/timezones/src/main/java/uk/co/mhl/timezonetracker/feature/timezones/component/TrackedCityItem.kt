package uk.co.mhl.timezonetracker.feature.timezones.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import java.time.ZoneId

@Composable
internal fun TrackedCityItem(
    modifier: Modifier = Modifier,
    currentTime: Instant,
    city: String,
    zoneId: String,
    onMoreClick: () -> Unit,
) {
    val zonedDateFormatted = zonedDateFormatted(currentTime, ZoneId.of(zoneId))

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                top = 16.dp,
                bottom = 16.dp,
                start = 16.dp,
                end = 8.dp,
            )
            .height(IntrinsicSize.Min),
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                text = city,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = .75f)
            )
            Text(
                text = zonedDateFormatted,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onBackground,
            )
        }
        Box(
            modifier = Modifier.fillMaxHeight(),
            contentAlignment = Alignment.Center,
        ) {
            IconButton(
                onClick = onMoreClick
            ) {
                Icon(
                    imageVector = Icons.Rounded.MoreVert,
                    contentDescription = stringResource(R.string.tracked_city_item_more),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
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
            onMoreClick = { },
        )
    }
}