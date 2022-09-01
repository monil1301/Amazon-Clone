package com.shah.amazonclone.ui.components.account

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shah.amazonclone.R
import com.shah.amazonclone.application.AmazonCloneApplication
import com.shah.amazonclone.ui.components.common.A_Column
import com.shah.amazonclone.ui.components.common.A_Row
import com.shah.amazonclone.utilities.helpers.UserHelper

/**
 * Created by Monil Shah on 01/09/22.
 */

@Composable
fun AccountButtonsSection(modifier: Modifier = Modifier) {

    val context = LocalContext.current
    val application by lazy { context.applicationContext as AmazonCloneApplication }

    A_Column(
        modifier = modifier
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        A_Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            RoundedCornerButton(
                modifier = Modifier
                    .weight(1f),
                title = stringResource(id = R.string.your_orders)
            ) {

            }

            RoundedCornerButton(
                modifier = Modifier
                    .weight(1f),
                title = stringResource(id = R.string.turn_seller)
            ) {

            }
        }

        A_Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            RoundedCornerButton(
                modifier = Modifier
                    .weight(1f),
                title = stringResource(id = R.string.logout)
            ) {
                UserHelper.logout(application)
            }

            RoundedCornerButton(
                modifier = Modifier
                    .weight(1f),
                title = stringResource(id = R.string.your_wish_list)
            ) {

            }
        }
    }
}

@Preview
@Composable
fun PreviewAccountButtonsSection() {
    AccountButtonsSection()
}
