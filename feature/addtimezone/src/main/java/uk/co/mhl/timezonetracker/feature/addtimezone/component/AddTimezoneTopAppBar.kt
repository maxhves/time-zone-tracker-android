package uk.co.mhl.timezonetracker.feature.addtimezone.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import uk.co.mhl.timezonetracker.core.designsystem.theme.TimezoneTrackerTheme
import uk.co.mhl.timezonetracker.feature.addtimezone.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AddTimezoneTopAppBar(
    onNavigateClick: () -> Unit,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
    TopAppBar(
        title = {
            // TODO: Add text field here.
            // TODO: We need to use a text field for querying city data.
        },
        modifier = modifier,
        navigationIcon = {
            IconButton(onNavigateClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                    tint = MaterialTheme.colorScheme.onSurface,
                    contentDescription = stringResource(R.string.navigate_up)
                )
            }
        },
        scrollBehavior = scrollBehavior,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun AddTimezoneTopAppBarPreview() {
    TimezoneTrackerTheme {
        AddTimezoneTopAppBar(
            onNavigateClick = { }
        )
    }
}