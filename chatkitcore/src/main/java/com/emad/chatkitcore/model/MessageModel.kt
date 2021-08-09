package com.emad.chatkitcore.model

data class MessageModel(val id: String) {

    lateinit var receiverId: String
    lateinit var name: String
    lateinit var message: String
    lateinit var senderEnum: MessageSenderEnum
    var date: Long = 0L

    fun equals(other: MessageModel): Boolean {
        return id == other.id &&
                name == other.name &&
                date == other.date &&
                message == other.message &&
                receiverId == other.receiverId &&
                senderEnum == other.senderEnum
    }
}