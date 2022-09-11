package com.shah.amazonclone.ui.components.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.shah.amazonclone.R
import com.shah.amazonclone.models.common.getA_TextConfig
import com.shah.amazonclone.ui.components.common.A_Row
import com.shah.amazonclone.ui.components.common.A_Text
import com.shah.amazonclone.utilities.helpers.UserHelper
import com.shah.amazonclone.utilities.utils.ifLet

/**
 * Created by Monil Shah on 02/09/22.
 */

@Composable
fun AddressBar() {
    ifLet(UserHelper.user?.name, UserHelper.user?.address) { (name, address) ->
        A_Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(color = MaterialTheme.colorScheme.primary.copy(0.8f))
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.weight(0.1f),
                imageVector = Icons.Outlined.LocationOn,
                contentDescription = "Location"
            )

            A_Text(
                modifier = Modifier.weight(1f),
                text = stringResource(
                    id = R.string.deliver_to_user_address,
                    name,
                    address
                ),
                config = getA_TextConfig(maxLines = 1, overflow = TextOverflow.Ellipsis)
            )

            Icon(
                modifier = Modifier.weight(0.1f),
                imageVector = Icons.Outlined.ArrowDropDown,
                contentDescription = "Drop Down"
            )
        }
    }
}
