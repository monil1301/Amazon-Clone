package com.shah.amazonclone.ui.screen

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.razorpay.Checkout
import com.shah.amazonclone.R
import com.shah.amazonclone.enums.PaymentState
import com.shah.amazonclone.models.CartItem
import com.shah.amazonclone.models.Order
import com.shah.amazonclone.ui.activities.RootBottomTabBarActivity
import com.shah.amazonclone.ui.components.common.A_Column
import com.shah.amazonclone.ui.components.common.A_RadioButton
import com.shah.amazonclone.ui.components.payment.PaymentTotalView
import com.shah.amazonclone.ui.components.topbar.TopBarWithBackButton
import com.shah.amazonclone.utilities.helpers.UserHelper
import com.shah.amazonclone.viewmodels.OrderViewModel

/**
 * Created by Monil Shah on 10/10/22.
 */

@Composable
fun PaymentDetailsScreen(onBackPress: () -> Unit, makePayment: (Float, (Boolean) -> Unit) -> Unit) {

    var paymentState by remember { mutableStateOf(PaymentState.PAY_NOW) }
    val isOrderBeingPlaced = remember { mutableStateOf(false) }
    val paymentViewModel = remember { OrderViewModel() }
    val context = LocalContext.current
    var address: String? = null

    Scaffold(
        topBar = {
            TopBarWithBackButton(title = "", onBackPress = onBackPress)
        }
    ) { paddingValues ->
        A_Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
                .padding(10.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            UserHelper.user?.address?.takeIf { it.isNotBlank() }?.let { _address ->
                address = _address
                Text(
                    text = stringResource(id = R.string.delivering_to),
                    style = MaterialTheme.typography.titleSmall
                )

                Text(
                    text = _address,
                    modifier = Modifier
                        .border(
                            1.dp,
                            MaterialTheme.colorScheme.outline,
                            RoundedCornerShape(4.dp)
                        )
                        .padding(8.dp)
                        .clip(RoundedCornerShape(4.dp))
                )
            }

            Spacer(modifier = Modifier.height(12.dp))
            Divider()
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = stringResource(id = R.string.payment_options),
                style = MaterialTheme.typography.titleSmall
            )

            A_RadioButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(horizontal = 8.dp),
                isSelected = paymentState == PaymentState.PAY_NOW,
                text = stringResource(id = R.string.pay_now),
                tint = MaterialTheme.colorScheme.secondary
            ) {
                paymentState = PaymentState.PAY_NOW
            }

            A_RadioButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(horizontal = 8.dp),
                isSelected = paymentState == PaymentState.COD,
                text = stringResource(id = R.string.cash_on_delivery),
                tint = MaterialTheme.colorScheme.secondary
            ) {
                paymentState = PaymentState.COD
            }

            A_RadioButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(horizontal = 8.dp),
                isSelected = paymentState == PaymentState.PAY_ON_VERIFICATION,
                text = stringResource(id = R.string.pay_on_verification),
                tint = MaterialTheme.colorScheme.secondary
            ) {
                paymentState = PaymentState.PAY_ON_VERIFICATION
            }

            Spacer(modifier = Modifier.height(12.dp))
            Divider()
            Spacer(modifier = Modifier.height(12.dp))

            UserHelper.user?.cart?.let { cartItems ->
                PaymentTotalView(cart = cartItems, isOrderBeingPlaced.value) { totalPrice ->
                    isOrderBeingPlaced.value = true

                    placeOrderBasedOnPaymentMode(
                        paymentState,
                        context,
                        makePayment,
                        totalPrice,
                        paymentViewModel,
                        cartItems,
                        address,
                        isOrderBeingPlaced
                    )
                }
            }
        }
    }
}

private fun placeOrderBasedOnPaymentMode(
    paymentState: PaymentState,
    context: Context,
    makePayment: (Float, (Boolean) -> Unit) -> Unit,
    totalPrice: Float,
    paymentViewModel: OrderViewModel,
    cartItems: List<CartItem>,
    address: String?,
    isOrderBeingPlaced: MutableState<Boolean>
) {
    when (paymentState) {
        PaymentState.PAY_NOW -> {
            Checkout.preload(context.applicationContext)
            makePayment(totalPrice) { isSuccess ->
                if (isSuccess) {
                    placeOrder(
                        paymentViewModel,
                        cartItems,
                        totalPrice,
                        address,
                        isOrderBeingPlaced,
                        context,
                        0
                    )
                } else {
                    Toast.makeText(
                        context,
                        "Payment Failed! Try again or chose other method",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
        PaymentState.COD -> {
            placeOrder(
                paymentViewModel,
                cartItems,
                totalPrice,
                address,
                isOrderBeingPlaced,
                context,
                1
            )
        }
        PaymentState.PAY_ON_VERIFICATION -> {
            placeOrder(
                paymentViewModel,
                cartItems,
                totalPrice,
                address,
                isOrderBeingPlaced,
                context,
                2
            )
        }
    }
}

private fun placeOrder(
    paymentViewModel: OrderViewModel,
    cartItems: List<CartItem>,
    totalPrice: Float,
    address: String?,
    isOrderBeingPlaced: MutableState<Boolean>,
    context: Context,
    paymentStatus: Int
) {
    paymentViewModel.placeOrder(
        Order(cartItems, totalPrice, address, paymentStatus = paymentStatus)
    ) {
        isOrderBeingPlaced.value = false
        if (it) {
            val intent = Intent(context, RootBottomTabBarActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
            context.startActivity(intent)
            Toast.makeText(context, "Hurrayyy!! Order placed", Toast.LENGTH_LONG).show()
        }
    }
}
