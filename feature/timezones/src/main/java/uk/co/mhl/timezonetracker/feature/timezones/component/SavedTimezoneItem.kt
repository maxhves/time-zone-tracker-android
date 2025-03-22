package uk.co.mhl.timezonetracker.feature.timezones.component

import androidx.compose.foundation.clickable
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
import uk.co.mhl.timezonetracker.core.designsystem.theme.TimezoneTrackerTheme

@Composable
internal fun SavedTimezoneItem(
    modifier: Modifier = Modifier,
    cityName: String,
    offset: Int,
    currentTime: Long,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable {  }
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = cityName,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = .75f)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "$currentTime",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onBackground,
            )
            Text(
                text = "$offset",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = .5f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SavedTimezoneItemPreview() {
    TimezoneTrackerTheme {
        SavedTimezoneItem(
            cityName = "Toronto",
            offset = -5,
            currentTime = 9883908928,
        )
    }
}