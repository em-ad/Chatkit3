package com.emad.chatkitcore.util

import android.net.Uri
import com.emad.chatkitcore.model.MessageModel
import com.thin.downloadmanager.DefaultRetryPolicy
import com.thin.downloadmanager.DownloadRequest
import com.thin.downloadmanager.ThinDownloadManager

class DownloadUtils {
    companion object{

        private var downloadManager: ThinDownloadManager? = null

        fun startDownload(messageModel: MessageModel, uri: Uri){
            initManager()
            var downloadRequest: DownloadRequest = DownloadRequest(Uri.parse(messageModel.url))
                .setRetryPolicy(DefaultRetryPolicy())
                .setDestinationURI(uri)
                .setPriority(DownloadRequest.Priority.HIGH)
                .setStatusListener(messageModel.download.listener)
            downloadManager?.add(downloadRequest)
        }

        private fun initManager() {
            if(downloadManager == null)
                downloadManager = ThinDownloadManager()
        }
    }
}