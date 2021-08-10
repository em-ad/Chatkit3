package com.emad.chatkitcore.model

import android.util.Log
import com.emad.chatkitcore.util.FileUtils
import com.thin.downloadmanager.DownloadRequest
import com.thin.downloadmanager.DownloadStatusListenerV1
import java.util.*

class DownloadStatus: Observable() {

    var progress = -1;
    var downloading = false
    var downloaded = false

    var listener = object : DownloadStatusListenerV1{
        override fun onDownloadComplete(downloadRequest: DownloadRequest?) {
            downloaded = true;
            downloading = false;
            notifyObservers()
            Log.e("TAG", "onDownloadComplete: " )
        }

        override fun onDownloadFailed(
            downloadRequest: DownloadRequest?,
            errorCode: Int,
            errorMessage: String?
        ) {
            downloaded = false;
            downloading = false;
            notifyObservers()
            Log.e("TAG", "onDownloadFailed: " + errorMessage )
        }

        override fun onProgress(
            downloadRequest: DownloadRequest?,
            totalBytes: Long,
            downloadedBytes: Long,
            progress: Int
        ) {
            downloading = true;
            this@DownloadStatus.progress = progress
            if(progress >= 100){
                downloaded = true;
                downloading = false;
            }
            notifyObservers()
            Log.e("TAG", "onProgress: " + progress )
        }

    }
}