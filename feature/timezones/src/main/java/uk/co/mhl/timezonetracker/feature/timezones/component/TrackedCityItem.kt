package uk.co.mhl.timezonetracker.feature.timezones.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.co.mhl.timezonetracker.core.designsystem.theme.TimeZoneTrackerTheme
import uk.co.mhl.timezonetracker.core.ui.zonedDateFormatted
import uk.co.mhl.timezonetracker.feature.timezones.R
import java.time.Instant
import java.time.ZoneId
import uk.co.mhl.timezonetracker.core.designsystem.R as RDesignSystem

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
            .background(
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colorScheme.surfaceContainerLow,
            )
            .padding(
                top = 16.dp,
                bottom = 16.dp,
                start = 16.dp,
                end = 4.dp,
            )
            .height(IntrinsicSize.Min),
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text(
                text = city,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = .75f)
            )
            Text(
                text = zonedDateFormatted,
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onSurface,
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
                    painter = painterResource(RDesignSystem.drawable.ic_more_vertical),
                    contentDescription = stringResource(R.string.tracked_city_item_more),
                    tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
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