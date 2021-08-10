package com.emad.chatkitcore.model

data class MessageModel(val id: String) {

    var receiverId: String = ""
    var name: String = ""
    var message: String = ""
    var url: String = ""
    var date: Long = 0L
    var download: DownloadStatus = DownloadStatus()
    var senderEnum: MessageSenderEnum = MessageSenderEnum.SELF

    fun equals(other: MessageModel): Boolean {
        return id == other.id &&
                name == other.name &&
                date == other.date &&
                message == other.message &&
                receiverId == other.receiverId &&
                senderEnum == other.senderEnum &&
                download == other.download &&
                url == other.url
    }
}