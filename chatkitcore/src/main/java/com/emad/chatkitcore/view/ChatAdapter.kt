package com.emad.chatkitcore.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.emad.chatkitcore.model.MessageModel
import com.emad.chatkitcore.util.MessageDiffUtil

class ChatAdapter(val chatResId: Int)
    : ListAdapter<MessageModel, ChatAdapter.ViewHolder>(MessageDiffUtil()) {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(chatResId, parent, false))
    }

    override fun onBindViewHolder(holder: ChatAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}