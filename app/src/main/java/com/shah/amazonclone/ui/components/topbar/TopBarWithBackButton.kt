package com.shah.amazonclone.ui.components.topbar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shah.amazonclone.models.common.getA_TextConfig
import com.shah.amazonclone.ui.components.common.A_Row
import com.shah.amazonclone.ui.components.common.A_Text

/**
 * Created by Monil Shah on 06/09/22.
 */

@Composable
fun TopBarWithBackButton(title: String, onBackPress: () -> Unit) {
    A_Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.primary)
            .padding(vertical = 12.dp, horizontal = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .padding(4.dp)
                .clickable { onBackPress() },
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back button"
        )
        A_Text(
            text = title,
            config = getA_TextConfig(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}
