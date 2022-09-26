package com.shah.amazonclone.ui.screen

import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.shah.amazonclone.R
import com.shah.amazonclone.models.product.Product
import com.shah.amazonclone.ui.components.common.A_Button
import com.shah.amazonclone.ui.components.common.A_Column
import com.shah.amazonclone.ui.components.common.A_DropdownMenu
import com.shah.amazonclone.ui.components.common.A_OutlinedTextField
import com.shah.amazonclone.ui.components.products.AddImagesView
import com.shah.amazonclone.ui.components.topbar.TopBarWithBackButton
import com.shah.amazonclone.utilities.helpers.CloudinaryHelper
import com.shah.amazonclone.utilities.utils.logD
import com.shah.amazonclone.viewmodels.ProductViewModel

/**
 * Created by Monil Shah on 05/09/22.
 */

@Composable
fun AddProductScreen(onBackPress: () -> Unit) {

    val context = LocalContext.current
    val productViewModel = remember { ProductViewModel() }
    val product = Product()
    val selectedImages = arrayListOf<Uri>()
    val focusManager = LocalFocusManager.current
    var isProductBeingAdded by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopBarWithBackButton(
                title = stringResource(id = R.string.add_product),
                onBackPress = onBackPress
            )
        }
    ) { paddingValues ->
        Box {
            A_Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(horizontal = 10.dp, vertical = 12.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                AddImagesView { uri ->
                    selectedImages.add(uri)
                }

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
                    product.name = it
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
                    product.description = it
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
                    try {
                        product.price = it.toFloat()
                    } catch (e: NumberFormatException) {
                        logD(message = "Number format exception for price in add product screen: $it")
                    }
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
                    product.quantity = it.toInt()
                }

                A_DropdownMenu(
                    title = stringResource(id = R.string.category),
                    menuItems = stringArrayResource(id = R.array.product_categories),
                    hasError = false,
                    errorMessage = "",
                ) {
                    product.category = it
                }

                A_Button(
                    modifier = Modifier.fillMaxWidth(),
                    title = stringResource(id = R.string.sell)
                ) {
                    isProductBeingAdded = true
                    uploadImagesToCloudinary(selectedImages) {
                        product.images = it
                        productViewModel.addProduct(product) { _, message ->
                            isProductBeingAdded = false
                            onBackPress()
                            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }

            if (isProductBeingAdded)
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(100.dp),
                    color = MaterialTheme.colorScheme.primary,
                    strokeWidth = 6.dp
                )
        }
    }
}

private fun uploadImagesToCloudinary(
    selectedImages: ArrayList<Uri>,
    onComplete: (ArrayList<String>) -> Unit
) {
    val uploadedImageUrlList = arrayListOf<String>()
    selectedImages.forEach { uri ->
        CloudinaryHelper.uploadImage(uri) { isSuccess, imageUrl, errorMessage ->
            if (isSuccess) {
                imageUrl?.let { url -> uploadedImageUrlList.add(url) }

                if (uploadedImageUrlList.size == selectedImages.size)
                    onComplete(uploadedImageUrlList)
            } else {
                logD(message = errorMessage.toString())
            }
        }
    }
}
