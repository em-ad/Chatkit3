package com.emad.chatkitcore.view

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.emad.chatkitcore.R
import com.emad.chatkitcore.model.MessageModel
import com.emad.chatkitcore.model.MessageSenderEnum
import com.emad.chatkitcore.util.DownloadUtils
import com.emad.chatkitcore.util.FileUtils
import com.emad.chatkitcore.util.MessageDiffUtil
import java.util.*
import kotlin.collections.ArrayList

class ChatAdapter(
    private val selfResId: Int,
    private val otherResId: Int,
    private val systemResId: Int
) : ListAdapter<MessageModel, ChatAdapter.ViewHolder>(MessageDiffUtil()) {

    private lateinit var context: Context

    override fun getItemViewType(position: Int): Int {
        return getItem(position).senderEnum.ordinal
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapter.ViewHolder {
        context = parent.context
        return when (viewType) {
            MessageSenderEnum.SELF.ordinal ->
                ViewHolder(LayoutInflater.from(parent.context).inflate(selfResId, parent, false))
            MessageSenderEnum.OTHER.ordinal ->
                ViewHolder(LayoutInflater.from(parent.context).inflate(otherResId, parent, false))
            else ->
                ViewHolder(LayoutInflater.from(parent.context).inflate(systemResId, parent, false))
        }
    }

    override fun onBindViewHolder(holder: ChatAdapter.ViewHolder, position: Int) {
        setViewValues(holder, position)
        checkDownloadable(holder, position)
//        if (getItem(position).download.downloaded)
//            holder.itemView.findViewById<ImageView>(R.id.iv_download).visibility = View.GONE
//        holder.itemView.findViewById<ImageView>(R.id.iv_download)
//            .setOnClickListener(View.OnClickListener {
//                DownloadUtils.startDownload(
//                    getItem(position),
//                    FileUtils.getFileUri(context, getItem(position))!!
//                )
//                getItem(position).download.addObserver(object : Observer {
//                    override fun update(p0: Observable?, p1: Any?) {
//                        Log.e("TAG", "update: " + p1 )
//                        notifyItemChanged(position)
//                    }
//                })
//            })

    }

    private fun setViewValues(holder: ChatAdapter.ViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.tv_message)?.text = getItem(position).message
        holder.itemView.findViewById<TextView>(R.id.tv_name)?.text = getItem(position).name
    }

    private fun checkDownloadable(holder: ChatAdapter.ViewHolder, position: Int) {
        if (getItem(position).url.isNotEmpty()) {
            holder.itemView.findViewById<ImageView>(R.id.iv_download).visibility = View.VISIBLE
        } else holder.itemView.findViewById<ImageView>(R.id.iv_download).visibility = View.GONE
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    fun addNewMessage(messageModel: MessageModel) {
        val messageList: ArrayList<MessageModel> = ArrayList()
        if (currentList.isNotEmpty())
            messageList.addAll(currentList)
        messageList.add(messageModel)
        submitList(messageList)
    }

    fun addNewMessageList(messageList: ArrayList<MessageModel>) {
        val current: ArrayList<MessageModel> = ArrayList()
        if (currentList.isNotEmpty())
            messageList.addAll(currentList)
        current.addAll(messageList)
        submitList(current)
    }

    fun refreshAndAddNewMessageList(messageList: ArrayList<MessageModel>) {
        submitList(messageList)
    }


}