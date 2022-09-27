package com.shah.amazonclone.ui.components.products

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.shah.amazonclone.models.product.Product
import com.shah.amazonclone.ui.activities.ProductDetailsActivity
import com.shah.amazonclone.ui.components.common.A_Column
import com.shah.amazonclone.ui.components.common.A_Row
import com.shah.amazonclone.ui.components.orders.OrderImageItem
import com.shah.amazonclone.utilities.helpers.Constants

/**
 * Created by Monil Shah on 13/09/22.
 */

@Composable
fun SingleProductView(
    product: Product,
    shouldShowDeleteIcon: Boolean = true,
    onDeleteClick: () -> Unit = {}
) {
    val context = LocalContext.current
    A_Column(
        Modifier
            .width(170.dp)
            .clickable {
                val intent = Intent(context, ProductDetailsActivity::class.java)
                intent.putExtra(Constants.BundleKeys.product, product)
                context.startActivity(intent)
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OrderImageItem(url = product.images?.firstOrNull() ?: "")

        A_Row(
            modifier = Modifier.padding(6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier.weight(0.7f),
                text = product.name ?: "",
                style = MaterialTheme.typography.displaySmall,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            if (shouldShowDeleteIcon)
                Icon(
                    modifier = Modifier
                        .weight(0.2f)
                        .clickable { onDeleteClick() },
                    imageVector = Icons.Outlined.Delete,
                    contentDescription = "Delete"
                )
        }
    }
}
