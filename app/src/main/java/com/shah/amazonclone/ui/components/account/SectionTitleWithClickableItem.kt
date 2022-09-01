package com.shah.amazonclone.ui.components.account

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
 * Created by Monil Shah on 01/09/22.
 */

@Composable
fun SectionTitleWithClickableItem(
    title: String,
    clickableText: String?,
    onClick: () -> Unit = {}
) {
    A_Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        A_Text(
            text = title,
            config = getA_TextConfig(
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.SemiBold
            )
        )

        clickableText?.let { text ->
            A_Text(
                modifier = Modifier
                    .clickable { onClick() },
                text = text,
                config = getA_TextConfig(
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            )
        }
    }
}
