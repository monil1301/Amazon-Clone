package com.shah.amazonclone.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import com.shah.amazonclone.ui.screen.PaymentDetailsScreen
import com.shah.amazonclone.ui.theme.AmazonCloneTheme
import com.shah.amazonclone.utilities.utils.logD
import org.json.JSONObject

/**
 * Created by Monil Shah on 06/09/22.
 */
class PaymentActivity : ComponentActivity(), PaymentResultListener {

    var onPayResult: (Boolean) -> Unit = {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmazonCloneTheme {
                PaymentDetailsScreen(onBackPress = { onBackPressed() }) { totalPrice, onResult ->
                    onPayResult = onResult
                    startPayment(totalPrice)
                }
            }
        }
    }

    private fun startPayment(totalPrice: Float) {
        val checkout = Checkout()
        checkout.setKeyID("rzp_test_hMXhPkFWpu3PAO")

        try {
            val amount = (totalPrice.toInt()) * 100
            val options = JSONObject()
            options.put("name", "Amazon")
            options.put("description", "Your Order Value")
            //You can omit the image option to fetch the image from dashboard
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.jpg")
            options.put("theme.color", "#48A3C6")
            options.put("currency", "INR")
            options.put("amount", amount.toString()) //pass amount in currency subunits

            val retryObj = JSONObject()
            retryObj.put("enabled", true)
            retryObj.put("max_count", 4)
            options.put("retry", retryObj)

            val prefill = JSONObject()
            prefill.put("email", "mvshah1301@gmail.com")
            prefill.put("contact", "8460445162")

            options.put("prefill", prefill)
            checkout.open(this, options)
        } catch (e: Exception) {
            Toast.makeText(this, "Error in payment: " + e.message, Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    override fun onPaymentSuccess(p0: String?) {
        onPayResult(true)
    }

    override fun onPaymentError(p0: Int, p1: String?) {
        onPayResult(false)
        logD(message = "failure: $p0, $p1")
    }
}
