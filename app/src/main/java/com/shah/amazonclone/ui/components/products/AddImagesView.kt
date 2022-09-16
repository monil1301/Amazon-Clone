package com.shah.amazonclone.ui.components.products

import android.Manifest
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Folder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shah.amazonclone.R
import com.shah.amazonclone.models.common.getA_TextConfig
import com.shah.amazonclone.ui.components.common.A_Column
import com.shah.amazonclone.ui.components.common.A_Text
import com.shah.amazonclone.ui.components.home.ImagesCarousel
import com.shah.amazonclone.utilities.utils.checkPermission


/**
 * Created by Monil Shah on 06/09/22.
 */

@Composable
fun AddImagesView(onSelect: (Uri) -> Unit) {

    val stroke = Stroke(
        width = 2f,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
    )

    val selectedImages: SnapshotStateList<Uri> = remember { mutableStateListOf() }

    val selectImageFromGallery =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            uri?.let {
                selectedImages.add(it)
                onSelect(it)
            }
        }

    val checkReadStoragePermission = getReadStoragePermissionChecker(
        onSelect = {
            selectImageFromGallery.launch("image/*")
        },
        context = LocalContext.current
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clickable {
                checkReadStoragePermission.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
            },
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawRoundRect(
                color = Color.Black,
                style = stroke,
                cornerRadius = CornerRadius(10f, 10f)
            )
        }

        A_Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Icon(
                modifier = Modifier.size(30.dp),
                imageVector = Icons.Outlined.Folder,
                contentDescription = "Folder"
            )

            A_Text(
                text = stringResource(id = R.string.select_product_images),
                config = getA_TextConfig(fontSize = 14.sp, color = Color.Gray)
            )
        }

        ImagesCarousel(selectedImages)
    }


}

@Composable
private fun getReadStoragePermissionChecker(
    onSelect: () -> Unit,
    context: Context,
) = checkPermission { isGranted ->
    if (isGranted)
        onSelect()
    else
        Toast.makeText(
            context,
            context.getString(R.string.gallery_permission_required),
            Toast.LENGTH_LONG
        ).show()
}
