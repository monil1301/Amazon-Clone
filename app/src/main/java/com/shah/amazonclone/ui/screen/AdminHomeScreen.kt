package com.shah.amazonclone.ui.screen

import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.shah.amazonclone.ui.activities.AddProductActivity
import com.shah.amazonclone.ui.components.common.A_Text

/**
 * Created by Monil Shah on 05/09/22.
 */

@Composable
fun AdminHomeScreen() {
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        A_Text(text = "Home Screen")

        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(12.dp),
            onClick = {
                context.startActivity(Intent(context, AddProductActivity::class.java))
            },
            shape = CircleShape,
            containerColor = MaterialTheme.colorScheme.secondary
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add Product")
        }
    }
}
