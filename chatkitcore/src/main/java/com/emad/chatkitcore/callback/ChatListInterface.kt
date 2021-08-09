package com.emad.chatkitcore.callback

import com.emad.chatkitcore.model.MessageModel

interface ChatListInterface {
    fun paginateNow()
    fun sendMessage(message: MessageModel)
}