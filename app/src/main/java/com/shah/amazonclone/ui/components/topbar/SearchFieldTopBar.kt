package com.shah.amazonclone.ui.components.topbar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Mic
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shah.amazonclone.R
import com.shah.amazonclone.ui.components.common.A_OutlinedTextField
import com.shah.amazonclone.ui.components.common.A_Row

/**
 * Created by Monil Shah on 02/09/22.
 */

@Composable
fun SearchFieldTopBar(
    query: String = "",
    hasBackNavigation: Boolean = false,
    onBackPress: () -> Unit = {},
    onSearch: (String) -> Unit
) {
    var searchQuery = query

    A_Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.primary)
            .padding(vertical = 8.dp, horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (hasBackNavigation) {
            Icon(
                modifier = Modifier
                    .padding(4.dp)
                    .weight(0.1f)
                    .clickable { onBackPress() },
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back button"
            )
        }

        Card(
            modifier = Modifier
                .height(46.dp)
                .weight(1f),
            elevation = 12.dp
        ) {
            A_OutlinedTextField(
                modifier = Modifier.height(46.dp),
                text = searchQuery,
                label = stringResource(id = R.string.search_amazon),
                shouldShouldLabel = false,
                startIcon = Icons.Outlined.Search,
                iconDescription = "Search",
                textStyle = MaterialTheme.typography.labelMedium,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        onSearch(searchQuery)
                    }
                )
            ) {
                searchQuery = it
            }
        }

        Icon(
            modifier = Modifier.weight(0.1f),
            imageVector = Icons.Outlined.Mic,
            contentDescription = "Microphone"
        )
    }
}

@Preview
@Composable
fun PreviewSearchFieldTopBar() {
    SearchFieldTopBar {}
}
