package uk.co.mhl.timezonetracker.feature.timezones.component

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.co.mhl.timezonetracker.core.designsystem.theme.TimeZoneTrackerTheme
import uk.co.mhl.timezonetracker.feature.timezones.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrackedCityOptionsModalBottomSheet(
    modifier: Modifier = Modifier,
    sheetState: SheetState = rememberModalBottomSheetState(),
    show: Boolean,
    onRemoveClick: () -> Unit,
    onDismiss: () -> Unit,
) {
    if (show) {
        ModalBottomSheet(
            modifier = modifier,
            onDismissRequest = onDismiss,
            sheetState = sheetState,
        ) {
            TrackedCityOptionsModalBottomSheet(
                onRemoveClick = onRemoveClick,
            )
        }
    }
}

@Composable
private fun TrackedCityOptionsModalBottomSheet(
    modifier: Modifier = Modifier,
    onRemoveClick: () -> Unit,
) {
    Column(
        modifier = modifier.padding(bottom = 16.dp),
    ) {
        TrackedCityOptionRow(
            onClick = onRemoveClick,
            icon = Icons.Outlined.Delete,
            label = R.string.remove_city_option_label,
        )
    }
}

@Composable
private fun TrackedCityOptionRow(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    @StringRes
    label: Int,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        Text(
            text = stringResource(label),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TrackedCityOptionsModalBottomSheetPreview() {
    TimeZoneTrackerTheme {
        TrackedCityOptionsModalBottomSheet(
            onRemoveClick = { },
        )
    }
}