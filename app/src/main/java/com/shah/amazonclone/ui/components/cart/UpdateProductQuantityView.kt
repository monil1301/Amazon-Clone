package com.shah.amazonclone.ui.components.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shah.amazonclone.ui.components.common.A_Row

/**
 * Created by Monil Shah on 08/10/22.
 */

@Composable
fun UpdateProductQuantityView(quantity: Int, onAdd: () -> Unit, onRemove: () -> Unit) {
    A_Row(
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(4.dp)
            )
            .clip(RoundedCornerShape(4.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.outline)
                .size(24.dp),
            onClick = { onRemove() }
        ) {
            Icon(
                modifier = Modifier.size(16.dp),
                imageVector = Icons.Default.Remove,
                contentDescription = "Remove"
            )
        }

        Text(
            modifier = Modifier
                .widthIn(min = 24.dp)
                .padding(4.dp),
            text = quantity.toString(),
            fontSize = 13.sp,
            textAlign = TextAlign.Center
        )

        IconButton(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.outline)
                .size(24.dp),
            onClick = { onAdd() }
        ) {
            Icon(
                modifier = Modifier.size(16.dp),
                imageVector = Icons.Default.Add,
                contentDescription = "Add"
            )
        }
    }
}

@Preview
@Composable
fun PreviewUpdateProductQuantityView() {
    UpdateProductQuantityView(quantity = 1, {}) {}
}
