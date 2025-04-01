package uk.co.mhl.timezonetracker.feature.addtimezone.component

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
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
    TopAppBar(
        title = {

//            TextField(
//                modifier = Modifier.fillMaxWidth().heightIn(max = 56.dp),
//                value = searchQuery,
//                onValueChange = onSearchQueryChange,
//                placeholder = { Text(text = "Search") },
//                textStyle = MaterialTheme.typography.bodyLarge,
//                maxLines = 1,
//                singleLine = true,
//            )
            SearchTextField()
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
@Composable
private fun SearchTextField() {
    val interactionSource = remember { MutableInteractionSource() }
    var testText by remember { mutableStateOf("") }

    // TODO: Wrap this in a column with a HorizontalDivider, so we can get the desired look.
    BasicTextField(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp),
        value = testText,
        onValueChange = { testText = it },
        textStyle = MaterialTheme.typography.bodyLarge,
        decorationBox =
            @Composable { innerTextField ->
                TextFieldDefaults.DecorationBox(
                    value = testText,
                    innerTextField = innerTextField,
                    placeholder = {
                        Text(text = "Search cities")
                    },
                    enabled = true,
                    singleLine = true,
                    visualTransformation = VisualTransformation.None,
                    interactionSource = interactionSource,
                    contentPadding = PaddingValues(0.dp),
                    shape = RoundedCornerShape(0.dp),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    )
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