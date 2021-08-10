package com.emad.chatkitcore.util

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.util.Log
import android.webkit.MimeTypeMap
import com.emad.chatkitcore.model.MessageModel
import java.io.File
import java.util.*

class FileUtils {
    companion object {
        fun exists(url: String): Boolean {

            return false;
        }

        fun checkFileExistence(context: Context, messageModel: MessageModel): Boolean {
            return if (context.getExternalFilesDir(null) == null || messageModel.url.isEmpty()) false else File(
                Objects.requireNonNull(context.getExternalFilesDir(null)).toString() + "/chatkit3/",
                messageModel.url
            ).exists()
        }

        fun getFileUri(context: Context, messageModel: MessageModel): Uri? {
            var uri = if (context.getExternalFilesDir(null) == null || messageModel.url.isEmpty())
                null
            else
                context.getExternalFilesDir(null).toString() + "/chatkit3/" + messageModel.url.replace("/", "").replace(":", "")
            return Uri.parse(uri)
        }

        fun getMimeType(context: Context, uri: Uri): String? {
            var mimeType: String? = null
            mimeType = if (ContentResolver.SCHEME_CONTENT == uri.scheme) {
                val cr = context.contentResolver
                cr.getType(uri)
            } else {
                val fileExtension = MimeTypeMap.getFileExtensionFromUrl(
                    uri
                        .toString()
                )
                MimeTypeMap.getSingleton().getMimeTypeFromExtension(
                    fileExtension.toLowerCase()
                )
            }
            return mimeType
        }
    }
}