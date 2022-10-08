package com.shah.amazonclone.models

import com.shah.amazonclone.models.product.Product

/**
 * Created by Monil Shah on 08/10/22.
 */

data class CartItem(val product: Product?, val quantity: Int?)
