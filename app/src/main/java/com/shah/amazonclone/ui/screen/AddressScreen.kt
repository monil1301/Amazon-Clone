package com.shah.amazonclone.ui.screen

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.shah.amazonclone.R
import com.shah.amazonclone.models.Address
import com.shah.amazonclone.models.common.getA_ButtonConfig
import com.shah.amazonclone.ui.activities.PaymentActivity
import com.shah.amazonclone.ui.components.address.newAddressInput
import com.shah.amazonclone.ui.components.common.A_Button
import com.shah.amazonclone.ui.components.common.A_Column
import com.shah.amazonclone.ui.components.topbar.TopBarWithBackButton
import com.shah.amazonclone.utilities.helpers.UserHelper
import com.shah.amazonclone.viewmodels.AddressViewModel

/**
 * Created by Monil Shah on 09/10/22.
 */

@Composable
fun AddressScreen(onBackPress: () -> Unit) {

    val addressViewModel = remember { AddressViewModel() }
    val context = LocalContext.current

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
        ) {
            UserHelper.user?.address?.takeIf { it.isNotBlank() }?.let { address ->
                A_Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = address,
                        modifier = Modifier
                            .border(
                                1.dp,
                                MaterialTheme.colorScheme.outline,
                                RoundedCornerShape(4.dp)
                            )
                            .padding(8.dp)
                            .clip(RoundedCornerShape(4.dp))
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(text = "OR")

                    Spacer(modifier = Modifier.height(20.dp))
                }
            }

            val getAddress = newAddressInput()

            Spacer(modifier = Modifier.height(12.dp))

            A_Button(
                modifier = Modifier.fillMaxWidth(),
                title = stringResource(id = R.string.proceed),
                buttonConfig = getA_ButtonConfig(backgroundColor = MaterialTheme.colorScheme.secondaryContainer)
            ) {
                saveAddressAndProceed(getAddress, addressViewModel, context) {
                    val intent = Intent(context, PaymentActivity::class.java)
                    context.startActivity(intent)
                }
            }
        }
    }
}

private fun saveAddressAndProceed(
    getAddress: () -> Pair<Boolean, String>,
    addressViewModel: AddressViewModel,
    context: Context,
    onProceed: () -> Unit,
) {
    val address = getAddress()
    if (address.first) {
        if (address.second.isNotBlank()) {
            addressViewModel.addAddress(Address(address.second)) {
                onProceed()
            }
        }
    } else if (!UserHelper.user?.address.isNullOrBlank()) {
        onProceed()
    } else {
        Toast.makeText(context, "Address is mandatory", Toast.LENGTH_LONG).show()
    }
}
