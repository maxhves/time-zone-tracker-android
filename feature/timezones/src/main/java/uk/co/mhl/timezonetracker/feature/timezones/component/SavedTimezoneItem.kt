package uk.co.mhl.timezonetracker.feature.timezones.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uk.co.mhl.timezonetracker.core.designsystem.theme.TimezoneTrackerTheme

@Composable
internal fun SavedTimezoneItem(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        Text(text = "Toronto")
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "04:45 AM",
            )
            Text(
                text = "-05:00 EST",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SavedTimezoneItemPreview() {
    TimezoneTrackerTheme {
        SavedTimezoneItem()
    }
}