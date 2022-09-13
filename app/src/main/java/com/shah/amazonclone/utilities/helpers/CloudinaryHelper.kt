package com.shah.amazonclone.utilities.helpers

import android.net.Uri
import com.cloudinary.android.MediaManager
import com.cloudinary.android.callback.ErrorInfo
import com.cloudinary.android.callback.UploadCallback

/**
 * Created by Monil Shah on 11/09/22.
 */

object CloudinaryHelper {

    private const val presetName = "zhrtfi2c"

    fun uploadImage(
        image: Uri,
        imagePath: String = "products",
        callBack: (isSuccess: Boolean, imageUrl: String?, errorMessage: String?) -> Unit,
    ) {
        MediaManager.get().upload(image).unsigned(presetName).option("resource_type", "image")
            .option("folder", imagePath)
            .callback(object : UploadCallback {
                override fun onStart(requestId: String?) {}

                override fun onProgress(requestId: String?, bytes: Long, totalBytes: Long) {}

                override fun onSuccess(requestId: String?, resultData: MutableMap<Any?, Any?>?) {
                    callBack(true, resultData?.get("secure_url").toString(), null)
                }

                override fun onError(requestId: String?, error: ErrorInfo?) {
                    callBack(false, null, error?.description ?: "")
                }

                override fun onReschedule(requestId: String?, error: ErrorInfo?) {}
            })
            .dispatch()
    }
}
