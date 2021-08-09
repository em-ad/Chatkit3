package com.emad.chatkitcore.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.emad.chatkitcore.R
import com.emad.chatkitcore.model.MessageModel
import com.emad.chatkitcore.util.MessageDiffUtil
import java.util.*
import kotlin.collections.ArrayList

class ChatAdapter(
    private val selfResId: Int,
    private val otherResId: Int,
    private val systemResId: Int
    ) : ListAdapter<MessageModel, ChatAdapter.ViewHolder>(MessageDiffUtil()) {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(selfResId, parent, false))
    }

    override fun onBindViewHolder(holder: ChatAdapter.ViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.tv_message).text = getItem(position).message
        Log.e("TAG", "onBindViewHolder: " + getItem(position).message )
    }

    fun addNewMessage(messageModel: MessageModel) {
        var messageList: ArrayList<MessageModel> = if(currentList.isNotEmpty())
            currentList as ArrayList
        else
            ArrayList<MessageModel>()
        messageList.add(messageModel)
        submitList(messageList)
        Log.e("TAG", "addNewMessage: " + messageList.size )
        notifyDataSetChanged()
    }
}