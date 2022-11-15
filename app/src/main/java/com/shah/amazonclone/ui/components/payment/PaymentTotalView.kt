package com.shah.amazonclone.ui.components.payment

import android.content.Context
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shah.amazonclone.R
import com.shah.amazonclone.models.CartItem
import com.shah.amazonclone.models.common.getA_ButtonConfig
import com.shah.amazonclone.ui.components.common.A_Button
import com.shah.amazonclone.ui.components.common.A_Column
import com.shah.amazonclone.ui.theme.OpenSans

/**
 * Created by Monil Shah on 09/10/22.
 */

@Composable
fun PaymentTotalView(
    cart: List<CartItem>,
    isOrderBeingPlaced: Boolean,
    onPlaceOrder: (Float) -> Unit
) {
    val context = LocalContext.current
    var total = 0f

    cart.forEach {
        total += (it.quantity ?: 1) * (it.product?.price ?: 0f)
    }

    val subtotalPriceText = getSubtotalPriceText(context, total)

    A_Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
    ) {
        Text(text = subtotalPriceText)

        Spacer(modifier = Modifier.height(8.dp))

        A_Button(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(id = R.string.place_order),
            buttonConfig = getA_ButtonConfig(
                backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
                isEnabled = !isOrderBeingPlaced,
                shouldShowLoader = isOrderBeingPlaced
            )
        ) {
            onPlaceOrder(total)
        }
    }
}

@Composable
private fun getSubtotalPriceText(
    context: Context,
    total: Float
): AnnotatedString {
    val subtotalPriceText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.onBackground,
                fontFamily = OpenSans,
                fontSize = 16.sp,
            )
        ) {
            append(stringResource(id = R.string.total))
        }
        append(" ")
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.onBackground,
                fontFamily = OpenSans,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            )
        ) {
            append(context.getString(R.string.rupees, total.toString()))
        }
    }
    return subtotalPriceText
}
