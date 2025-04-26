package uk.co.mhl.timezonetracker.core.designsystem.component

import androidx.annotation.StringRes
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import uk.co.mhl.timezonetracker.core.designsystem.theme.TimeZoneTrackerTheme

//region Top App Bar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeZoneTrackerTopAppBar(
    @StringRes titleRes: Int,
    modifier: Modifier = Modifier,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        colors = colors,
        title = { Text(text = stringResource(titleRes)) },
    )
    // MediumTopApBar
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun TimeZoneTrackerTopAppBarPreview() {
    TimeZoneTrackerTheme {
        TimeZoneTrackerTopAppBar(
            titleRes = android.R.string.untitled,
        )
    }
}

//endregion
