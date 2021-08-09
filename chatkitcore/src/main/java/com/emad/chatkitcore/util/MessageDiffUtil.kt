package com.emad.chatkitcore.util

import androidx.recyclerview.widget.DiffUtil
import com.emad.chatkitcore.model.MessageModel

class MessageDiffUtil : DiffUtil.ItemCallback<MessageModel>() {
    override fun areItemsTheSame(oldItem: MessageModel, newItem: MessageModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MessageModel, newItem: MessageModel): Boolean {
        return oldItem.equals(newItem)
    }
}