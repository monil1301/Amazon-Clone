package com.shah.amazonclone.ui.components.topbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shah.amazonclone.R
import com.shah.amazonclone.models.common.getA_TextConfig
import com.shah.amazonclone.ui.components.common.A_Column
import com.shah.amazonclone.ui.components.common.A_Row
import com.shah.amazonclone.ui.components.common.A_Text
import com.shah.amazonclone.utilities.helpers.UserHelper

/**
 * Created by Monil Shah on 01/09/22.
 */

@Composable
fun AccountScreenTopBar() {
    A_Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.primary)
            .padding(vertical = 8.dp, horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        A_Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.height(30.dp),
                painter = painterResource(id = R.drawable.amazon_in_logo),
                contentDescription = "Amazon.in"
            )

            A_Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Notifications,
                    contentDescription = "Notification"
                )

                Icon(imageVector = Icons.Outlined.Search, contentDescription = "Search")
            }
        }

        UserHelper.user?.name?.let { name ->
            A_Text(
                text = stringResource(id = R.string.hello_user_name, name),
                config = getA_TextConfig(fontSize = 20.sp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewAccountScreenTopBar() {
    AccountScreenTopBar()
}
