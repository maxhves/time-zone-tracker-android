package uk.co.mhl.timezonetracker.feature.addtimezone.component

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.co.mhl.timezonetracker.core.designsystem.theme.TimezoneTrackerTheme
import uk.co.mhl.timezonetracker.feature.addtimezone.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AddTimezoneTopAppBar(
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    onNavigateClick: () -> Unit,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
    Column {
        TopAppBar(
            title = {
                SearchTextField(
                    searchQuery = searchQuery,
                    onSearchQueryChange = onSearchQueryChange,
                )
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
        HorizontalDivider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.1f))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SearchTextField(
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }

    val textStyle = MaterialTheme.typography.bodyLarge.merge(
        TextStyle(color = MaterialTheme.colorScheme.onSurface)
    )

    BasicTextField(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp),
        value = searchQuery,
        onValueChange = onSearchQueryChange,
        textStyle = textStyle,
        maxLines = 1,
        cursorBrush = SolidColor(MaterialTheme.colorScheme.onSurface),
        decorationBox =
            @Composable { innerTextField ->
                TextFieldDefaults.DecorationBox(
                    value = searchQuery,
                    innerTextField = innerTextField,
                    placeholder = { Text(text = "Search cities") },
                    enabled = true,
                    singleLine = true,
                    visualTransformation = VisualTransformation.None,
                    interactionSource = interactionSource,
                    contentPadding = PaddingValues(0.dp),
                    shape = RoundedCornerShape(0.dp),
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                    ),
                )
            }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun AddTimezoneTopAppBarPreview() {
    TimezoneTrackerTheme {
        AddTimezoneTopAppBar(
            searchQuery = "",
            onSearchQueryChange = { },
            onNavigateClick = { }
        )
    }
}