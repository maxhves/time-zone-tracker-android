package uk.co.mhl.timezonetracker.feature.addtimezone

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uk.co.mhl.timezonetracker.core.designsystem.theme.TimezoneTrackerTheme

@Composable
internal fun AddTimezoneScreen(
    onCitySelected: () -> Unit,
    modifier: Modifier = Modifier,
) {
    AddTimezoneScreen(
        cities = emptyList(),
        onCitySelected = onCitySelected,
        modifier = modifier,
    )
}

@Composable
internal fun AddTimezoneScreen(
    cities: List<String>,
    onCitySelected: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Text(text = "Add timezone content _will_ go here.")
}

@Preview
@Composable
private fun AddTimezoneScreenPreview() {
    TimezoneTrackerTheme {
        AddTimezoneScreen(
            cities = emptyList(),
            onCitySelected = { },
        )
    }
}