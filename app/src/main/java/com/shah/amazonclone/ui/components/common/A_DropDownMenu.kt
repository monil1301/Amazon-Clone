package com.shah.amazonclone.ui.components.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * Created by Monil Shah on 11/09/22.
 */

@Composable
fun A_DropdownMenu(
    title: String,
    menuItems: Array<String>,
    hasError: Boolean,
    errorMessage: String?,
    onItemSelected: (String) -> Unit,
) {
    var isDropDownExpanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("") }

    Box(
        Modifier
            .wrapContentSize(Alignment.TopStart)
    ) {
        A_OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { isDropDownExpanded = !isDropDownExpanded },
            label = title,
            endIcon = Icons.Default.ArrowDropDown,
            isReadOnly = true,
            isEnabled = false,
            isError = hasError,
            errorMessage = errorMessage,
            text = selectedItem,
            onValueChanged = {}
        )

        DropdownMenu(
            expanded = isDropDownExpanded,
            onDismissRequest = {
                isDropDownExpanded = false
            }
        ) {
            menuItems.forEach { item ->
                DropdownMenuItem(
                    onClick = {
                        selectedItem = item
                        isDropDownExpanded = false
                        onItemSelected(item)
                    }
                ) {
                    Text(text = item, style = MaterialTheme.typography.displaySmall)
                }
            }
        }
    }
}
