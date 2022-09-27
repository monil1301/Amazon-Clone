package com.shah.amazonclone.ui.screen

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle
import com.gowtham.ratingbar.StepSize
import com.shah.amazonclone.R
import com.shah.amazonclone.models.common.getA_ButtonConfig
import com.shah.amazonclone.models.product.Product
import com.shah.amazonclone.ui.activities.SearchActivity
import com.shah.amazonclone.ui.components.common.A_Button
import com.shah.amazonclone.ui.components.common.A_Column
import com.shah.amazonclone.ui.components.home.ImageCarousel
import com.shah.amazonclone.ui.components.products.OrderIdWithRatingView
import com.shah.amazonclone.ui.components.topbar.SearchFieldTopBar
import com.shah.amazonclone.ui.theme.OpenSans
import com.shah.amazonclone.utilities.helpers.Constants

/**
 * Created by Monil Shah on 26/09/22.
 */

@Composable
fun ProductDetailsScreen(product: Product, onBackPressed: () -> Unit) {
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            SearchFieldTopBar(
                hasBackNavigation = true,
                onBackPress = onBackPressed
            ) { searchQuery ->
                val intent = Intent(context, SearchActivity::class.java)
                intent.putExtra(Constants.BundleKeys.searchQuery, searchQuery)
                context.startActivity(intent)
            }
        }
    ) { paddingValues ->
        A_Column(
            modifier = Modifier
                .padding(12.dp)
                .padding(paddingValues)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OrderIdWithRatingView(id = product._id ?: "", rating = product.rating)

            Text(
                text = product.name ?: "",
                style = MaterialTheme.typography.displayMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            product.images?.let {
                ImageCarousel(
                    imageUrls = it,
                    imageModifier = Modifier
                        .fillMaxWidth(),
                    contentScale = ContentScale.FillWidth,
                    showIndicator = true
                )
            }

            val dealPriceText = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontFamily = OpenSans,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                    )
                ) {
                    append(stringResource(id = R.string.deal_price))
                }
                append(" ")
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colorScheme.secondary,
                        fontFamily = OpenSans,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                    )
                ) {
                    append(context.getString(R.string.rupees, product.price.toString()))
                }
            }

            Text(text = dealPriceText)

            Text(text = product.description ?: "", style = MaterialTheme.typography.displaySmall)

            A_Button(
                modifier = Modifier.fillMaxWidth(),
                title = stringResource(id = R.string.buy_now),
                buttonConfig = getA_ButtonConfig(backgroundColor = MaterialTheme.colorScheme.secondary)

            ) {

            }

            A_Button(
                modifier = Modifier.fillMaxWidth(),
                title = stringResource(id = R.string.add_to_cart),
                buttonConfig = getA_ButtonConfig(backgroundColor = MaterialTheme.colorScheme.secondaryContainer)
            ) {

            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = stringResource(id = R.string.rate_the_product),
                style = MaterialTheme.typography.titleLarge
            )

            var rating by remember { mutableStateOf(0f) }

            val config = RatingBarConfig()
                .activeColor(MaterialTheme.colorScheme.secondary)
                .inactiveColor(MaterialTheme.colorScheme.background)
                .inactiveBorderColor(MaterialTheme.colorScheme.secondary)
                .stepSize(StepSize.HALF)
                .numStars(Constants.Size.ratingRange)
                .isIndicator(false)
                .size(32.dp)
                .padding(6.dp)
                .style(RatingBarStyle.HighLighted)

            RatingBar(
                value = rating,
                config = config,
                onValueChange = {
                    rating = it
                }, onRatingChanged = {
                    rating = it
                }
            )
        }
    }
}
