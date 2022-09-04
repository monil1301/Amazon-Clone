package com.shah.amazonclone.ui.components.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shah.amazonclone.R
import com.shah.amazonclone.models.home.ProductCategory

/**
 * Created by Monil Shah on 04/09/22.
 */

@Composable
fun TopCategories() {
    val topCategories = listOf(
        ProductCategory(
            stringResource(id = R.string.mobiles),
            painterResource(id = R.drawable.mobiles)
        ),
        ProductCategory(
            stringResource(id = R.string.essentials),
            painterResource(id = R.drawable.essentials)
        ),
        ProductCategory(
            stringResource(id = R.string.appliances),
            painterResource(id = R.drawable.appliances)
        ),
        ProductCategory(
            stringResource(id = R.string.books),
            painterResource(id = R.drawable.books)
        ),
        ProductCategory(
            stringResource(id = R.string.fashion),
            painterResource(id = R.drawable.fashion)
        )
    )

    LazyRow(
        contentPadding = PaddingValues(all = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items = topCategories) { productCategory ->
            ProductCategoryView(category = productCategory)
        }
    }
}

@Preview
@Composable
fun PreviewTopCategories() {
    TopCategories()
}
