package uk.co.mhl.timezonetracker.feature.timezones.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uk.co.mhl.timezonetracker.core.designsystem.theme.TimeZoneTrackerTheme

@Composable
internal fun NewTimeZoneFloatingActionButton(
    onClick: () -> Unit,
) {
    ExtendedFloatingActionButton(
        onClick = onClick,
        icon = { Icon(Icons.Rounded.Add, "") },
        // TODO: Abstract string into strings file.
        text = { Text(text = "New Time Zone") },
    )
}

@Preview
@Composable
private fun NewTimeZoneFloatingActionButtonPreview() {
    TimeZoneTrackerTheme {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center,
        ) {
            NewTimeZoneFloatingActionButton { }
        }
    }
}