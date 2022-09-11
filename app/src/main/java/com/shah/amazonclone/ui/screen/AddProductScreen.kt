package com.shah.amazonclone.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.shah.amazonclone.R
import com.shah.amazonclone.ui.components.addproducts.AddImagesView
import com.shah.amazonclone.ui.components.common.A_Button
import com.shah.amazonclone.ui.components.common.A_Column
import com.shah.amazonclone.ui.components.common.A_DropdownMenu
import com.shah.amazonclone.ui.components.common.A_OutlinedTextField
import com.shah.amazonclone.ui.components.topbar.TopBarWithBackButton

/**
 * Created by Monil Shah on 05/09/22.
 */

@Composable
fun AddProductScreen(onBackPress: () -> Unit) {
    var productName = ""
    var description = ""
    var price = ""
    var quality = ""
    var category = ""

    val focusManager = LocalFocusManager.current

    Scaffold(
        topBar = {
            TopBarWithBackButton(
                title = stringResource(id = R.string.add_product),
                onBackPress = onBackPress
            )
        }
    ) { paddingValues ->
        A_Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 10.dp, vertical = 12.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            AddImagesView()

            A_OutlinedTextField(
                label = stringResource(id = R.string.product_name),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                )
            ) {
                productName = it
            }

            A_OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                label = stringResource(id = R.string.description),
                singleLine = false,
                fieldHeight = 150.dp,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Default,
                    capitalization = KeyboardCapitalization.Sentences
                ),
            ) {
                description = it
            }

            A_OutlinedTextField(
                label = stringResource(id = R.string.price),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                )
            ) {
                price = it
            }

            A_OutlinedTextField(
                label = stringResource(id = R.string.quantity),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        focusManager.clearFocus()
                    }
                )
            ) {
                quality = it
            }

            A_DropdownMenu(
                title = stringResource(id = R.string.category),
                menuItems = stringArrayResource(id = R.array.product_categories),
                hasError = false,
                errorMessage = "",
            ) {
                category = it
            }

            A_Button(
                modifier = Modifier.fillMaxWidth(),
                title = stringResource(id = R.string.sell)
            ) {

            }
        }
    }
}