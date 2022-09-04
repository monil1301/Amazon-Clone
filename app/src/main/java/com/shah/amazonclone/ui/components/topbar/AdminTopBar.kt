package com.shah.amazonclone.ui.components.topbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shah.amazonclone.R
import com.shah.amazonclone.models.common.getA_TextConfig
import com.shah.amazonclone.ui.components.common.A_Row
import com.shah.amazonclone.ui.components.common.A_Text

/**
 * Created by Monil Shah on 05/09/22.
 */

@Composable
fun AdminTopBar() {
    A_Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.primary)
            .padding(vertical = 12.dp, horizontal = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.height(30.dp),
            painter = painterResource(id = R.drawable.amazon_in_logo),
            contentDescription = "Amazon.in"
        )

        A_Text(
            text = stringResource(id = R.string.admin),
            config = getA_TextConfig(fontSize = 20.sp, fontWeight = FontWeight.Bold)
        )
    }
}

@Preview
@Composable
fun PreviewAdminTopBar() {
    AdminTopBar()
}
