package com.shah.amazonclone.ui.screen

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.shah.amazonclone.ui.activities.SearchActivity
import com.shah.amazonclone.ui.components.cart.CartItemView
import com.shah.amazonclone.ui.components.cart.CartSubTotalView
import com.shah.amazonclone.ui.components.home.AddressBar
import com.shah.amazonclone.ui.components.topbar.SearchFieldTopBar
import com.shah.amazonclone.utilities.helpers.Constants
import com.shah.amazonclone.utilities.helpers.FlowEvents
import com.shah.amazonclone.utilities.helpers.UserHelper
import com.shah.amazonclone.viewmodels.CartViewModel
import kotlinx.coroutines.launch

/**
 * Created by Monil Shah on 01/09/22.
 */

@Composable
fun CartScreen() {
    val context = LocalContext.current
    val cartViewModel = remember { CartViewModel() }
    LocalFocusManager.current.clearFocus()

    var cart by remember {
        mutableStateOf(UserHelper.user?.cart)
    }

    LaunchedEffect(key1 = Unit) {
        launch {
            FlowEvents.userCart.collect {
                cart = it
            }
        }
    }

    Scaffold(
        topBar = {
            SearchFieldTopBar { searchQuery ->
                val intent = Intent(context, SearchActivity::class.java)
                intent.putExtra(Constants.BundleKeys.searchQuery, searchQuery)
                context.startActivity(intent)
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier.padding(it),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                AddressBar()
            }

            item {
                cart?.takeIf { list -> list.isNotEmpty() }
                    ?.let { cart -> CartSubTotalView(cart = cart) }
            }

            cart?.let { cart ->
                items(items = cart) { cartItem ->
                    CartItemView(
                        cartItem = cartItem,
                        onAdd = {
                            cartItem.product?.let { product -> cartViewModel.addToCart(product) {} }
                        }
                    ) {
                        cartItem.product?._id?.let { id -> cartViewModel.removeFromCart(id) {} }
                    }
                }
            }
        }
    }
}
