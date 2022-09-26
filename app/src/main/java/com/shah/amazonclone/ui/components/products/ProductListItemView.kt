package com.shah.amazonclone.ui.components.products

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.shah.amazonclone.R
import com.shah.amazonclone.models.product.Product
import com.shah.amazonclone.ui.components.common.A_Column
import com.shah.amazonclone.ui.components.common.A_Image
import com.shah.amazonclone.ui.components.common.A_RatingBar
import com.shah.amazonclone.ui.components.common.A_Row

/**
 * Created by Monil Shah on 24/09/22.
 */

@Composable
fun ProductListItemView(product: Product) {
    A_Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        A_Image(
            modifier = Modifier
                .size(140.dp),
            url = product.images?.firstOrNull(),
            contentScale = ContentScale.FillWidth
        )

        A_Column {
            Text(
                text = product.name ?: "",
                style = MaterialTheme.typography.displayLarge,
                maxLines = 2
            )

            A_RatingBar(currentRating = product.rating ?: 0f)

            Text(
                text = stringResource(id = R.string.rupees, product.price.toString()),
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = stringResource(id = R.string.free_shipping_eligible),
                style = MaterialTheme.typography.displayMedium,
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(2.dp))

            val stockText = when {
                ((product.quantity ?: 0) > 10) -> stringResource(id = R.string.in_stock)
                ((product.quantity ?: 0) > 0) -> stringResource(id = R.string.only_few_left)
                else -> stringResource(id = R.string.out_of_stock)
            }

            Text(
                text = stockText,
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.primary,
                maxLines = 1
            )
        }
    }
}
