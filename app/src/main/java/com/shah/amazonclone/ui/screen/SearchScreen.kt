package com.shah.amazonclone.ui.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.shah.amazonclone.ui.components.products.ProductListItemView
import com.shah.amazonclone.ui.components.topbar.SearchFieldTopBar
import com.shah.amazonclone.viewmodels.SearchViewModel

/**
 * Created by Monil Shah on 23/09/22.
 */

@Composable
fun SearchScreen(searchQuery: String, onBackPress: () -> Unit) {

    val searchViewModel = remember { SearchViewModel() }

    if (searchQuery.isNotBlank()) {
        searchViewModel.searchProduct(searchQuery) {}
    }

    Scaffold(
        topBar = {
            SearchFieldTopBar(searchQuery, true, onBackPress) { searchQuery ->
                searchViewModel.searchProduct(searchQuery) {}
            }
        }
    ) {
        LazyColumn {
            items(items = searchViewModel.products) {
                ProductListItemView(product = it)
            }
        }
    }
}
