package com.shah.amazonclone.ui.screen

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.shah.amazonclone.ui.activities.AddProductActivity
import com.shah.amazonclone.ui.components.common.A_Row
import com.shah.amazonclone.ui.components.products.SingleProductView
import com.shah.amazonclone.viewmodels.ProductViewModel

/**
 * Created by Monil Shah on 05/09/22.
 */

@Composable
fun AdminHomeScreen() {
    val context = LocalContext.current
    val productViewModel = remember { ProductViewModel() }

    productViewModel.getAllProducts { message ->
//        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            contentPadding = PaddingValues(vertical = 16.dp, horizontal = 12.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(items = productViewModel.products.chunked(2)) {
                A_Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    it.forEach {
                        SingleProductView(product = it) {
                            it._id?.let { it1 -> productViewModel.deleteProduct(it1) {} }
                        }
                    }
                }
            }
        }

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
