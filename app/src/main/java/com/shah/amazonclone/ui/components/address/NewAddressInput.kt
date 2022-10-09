package com.shah.amazonclone.ui.components.address

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.shah.amazonclone.R
import com.shah.amazonclone.ui.components.common.A_Column
import com.shah.amazonclone.ui.components.common.A_OutlinedTextField

/**
 * Created by Monil Shah on 09/10/22.
 */

@Composable
fun newAddressInput(): () -> Pair<Boolean, String> {
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current

    var flat = ""
    var area = ""
    var pinCode = ""
    var town = ""

    A_Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        A_OutlinedTextField(
            label = stringResource(id = R.string.flat_house_no),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Words
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            )
        ) {
            flat = it
        }

        A_OutlinedTextField(
            label = stringResource(id = R.string.area_street),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Words
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            )
        ) {
            area = it
        }

        A_OutlinedTextField(
            label = stringResource(id = R.string.pin_code),
            maxCharacterLength = 6,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next,
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            )
        ) {
            pinCode = it
        }

        A_OutlinedTextField(
            label = stringResource(id = R.string.town_or_city),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                capitalization = KeyboardCapitalization.Words
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            )
        ) {
            town = it
        }
    }

    return {
        generateAddressString(context, flat, area, town, pinCode)
    }
}

private fun generateAddressString(
    context: Context,
    flat: String,
    area: String,
    town: String,
    pinCode: String
): Pair<Boolean, String> {
    val address = "$flat, $area, $town - $pinCode"
    return if (address.length > 7) {
        if (flat.isBlank() || area.isBlank() || pinCode.isBlank() || town.isBlank()) {
            Toast.makeText(
                context,
                "Invalid address. Please enter valid address",
                Toast.LENGTH_LONG
            ).show()
            Pair(true, "")
        } else {
            Pair(true, address)
        }
    } else {
        Pair(false, "")
    }
}
