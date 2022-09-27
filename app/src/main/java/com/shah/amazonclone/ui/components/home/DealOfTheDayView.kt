package com.shah.amazonclone.ui.components.home

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shah.amazonclone.R
import com.shah.amazonclone.models.common.getA_TextConfig
import com.shah.amazonclone.models.product.Product
import com.shah.amazonclone.ui.activities.ProductDetailsActivity
import com.shah.amazonclone.ui.components.account.SectionTitleWithClickableItem
import com.shah.amazonclone.ui.components.common.A_Column
import com.shah.amazonclone.ui.components.common.A_Image
import com.shah.amazonclone.ui.components.common.A_Text
import com.shah.amazonclone.utilities.helpers.Constants

/**
 * Created by Monil Shah on 04/09/22.
 */

@Composable
fun DealOfTheDayView(product: Product) {

    val context = LocalContext.current

    A_Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                val intent = Intent(context, ProductDetailsActivity::class.java)
                intent.putExtra(Constants.BundleKeys.product, product)
                context.startActivity(intent)
            },
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        SectionTitleWithClickableItem(
            title = stringResource(id = R.string.deal_of_the_day),
        )

        A_Image(
            url = product.images?.firstOrNull(),
            contentScale = ContentScale.FillWidth
        )

        A_Text(
            text = stringResource(id = R.string.rupees, product.price.toString()),
            config = getA_TextConfig(fontSize = 16.sp)
        )

        Text(
            text = product.name ?: "",
            style = MaterialTheme.typography.displaySmall,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2
        )

        LazyRow {
            items(items = product.images ?: listOf()) {
                A_Image(
                    url = it,
                    modifier = Modifier.size(100.dp),
                    contentScale = ContentScale.FillWidth
                )
            }
        }
    }
}
