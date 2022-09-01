package com.shah.amazonclone.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.shah.amazonclone.R
import com.shah.amazonclone.ui.components.account.AccountButtonsSection
import com.shah.amazonclone.ui.components.account.SectionTitleWithClickableItem
import com.shah.amazonclone.ui.components.common.A_Column
import com.shah.amazonclone.ui.components.orders.OrderImageItem
import com.shah.amazonclone.ui.components.topbar.AccountScreenTopBar

/**
 * Created by Monil Shah on 01/09/22.
 */

@Composable
fun AccountScreen() {
    Scaffold(
        topBar = {
            AccountScreenTopBar()
        }
    ) { paddingValues ->
        A_Column(
            modifier = Modifier.padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AccountButtonsSection()

            SectionTitleWithClickableItem(
                title = stringResource(id = R.string.your_orders),
                clickableText = stringResource(id = R.string.see_all)
            )

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
            ) {
                items(
                    items = listOf(
                        "https://photographylife.com/wp-content/uploads/2020/12/Apple-MacBook-Air-M1.jpg",
                        "https://photographylife.com/wp-content/uploads/2020/12/Apple-MacBook-Air-M1.jpg",
                        "https://photographylife.com/wp-content/uploads/2020/12/Apple-MacBook-Air-M1.jpg"
                    )
                ) {
                    OrderImageItem(url = it)
                }
            }
        }
    }
}
