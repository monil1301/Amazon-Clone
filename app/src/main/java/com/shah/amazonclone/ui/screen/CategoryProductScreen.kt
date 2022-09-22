package com.shah.amazonclone.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.shah.amazonclone.R
import com.shah.amazonclone.ui.components.common.A_Row
import com.shah.amazonclone.ui.components.products.SingleProductView
import com.shah.amazonclone.ui.components.topbar.TopBarWithBackButton
import com.shah.amazonclone.viewmodels.ProductCategoryViewModel

/**
 * Created by Monil Shah on 17/09/22.
 */

@Composable
fun CategoryProductScreen(category: String, onBackPress: () -> Unit) {

    val productCategoryViewModel = remember { ProductCategoryViewModel() }
    productCategoryViewModel.getProductsByCategory(category)

    Scaffold(
        topBar = {
            TopBarWithBackButton(title = category) {
                onBackPress()
            }
        }
    ) {
        LazyColumn(
            contentPadding = PaddingValues(vertical = 16.dp, horizontal = 12.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = stringResource(id = R.string.keep_shopping_for_category, category),
                    style = MaterialTheme.typography.titleMedium
                )
            }

            items(items = productCategoryViewModel.products.chunked(2)) {
                A_Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    it.forEach {
                        SingleProductView(product = it, shouldShowDeleteIcon = false)
                    }
                }
            }
        }
    }
}
