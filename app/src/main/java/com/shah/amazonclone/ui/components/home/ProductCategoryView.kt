package com.shah.amazonclone.ui.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shah.amazonclone.R
import com.shah.amazonclone.models.home.ProductCategory
import com.shah.amazonclone.ui.components.common.A_Column

/**
 * Created by Monil Shah on 04/09/22.
 */

@Composable
fun ProductCategoryView(category: ProductCategory) {
    A_Column(
        modifier = Modifier.size(60.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
            painter = category.image,
            contentDescription = category.title,
        )

        Text(text = category.title, style = MaterialTheme.typography.labelMedium)
    }
}

@Preview
@Composable
fun PreviewProductCategoryView() {
    ProductCategoryView(
        category = ProductCategory(
            stringResource(id = R.string.mobiles),
            painterResource(id = R.drawable.mobiles)
        )
    )
}
