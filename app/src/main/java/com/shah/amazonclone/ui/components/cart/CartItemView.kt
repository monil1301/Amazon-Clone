package com.shah.amazonclone.ui.components.cart

import androidx.compose.runtime.Composable
import com.shah.amazonclone.models.CartItem
import com.shah.amazonclone.ui.components.common.A_Column
import com.shah.amazonclone.ui.components.products.ProductListItemView

/**
 * Created by Monil Shah on 08/10/22.
 */

@Composable
fun CartItemView(cartItem: CartItem, onAdd: () -> Unit, onRemove: () -> Unit) {
    A_Column {
        cartItem.product?.let { product -> ProductListItemView(product = product) }

        cartItem.quantity?.let { quantity ->
            UpdateProductQuantityView(
                quantity = quantity,
                onAdd = onAdd,
                onRemove = onRemove
            )
        }
    }
}
