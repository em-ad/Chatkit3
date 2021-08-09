package com.emad.chatkitcore.view

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.emad.chatkitcore.callback.ChatListInterface
import com.emad.chatkitcore.model.MessageModel

class ChatListView : RecyclerView {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    var selfResId: Int = -1
    var otherResId: Int = -1
    var systemResId: Int = -1
    private var chatListInterface: ChatListInterface? = null
    private lateinit var adapter: ChatAdapter

    private var mScrollListener: OnScrollListener = object : OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            if (recyclerView.layoutManager == null) return
            if (recyclerView.layoutManager!!.childCount +
                (recyclerView.layoutManager as LinearLayoutManager?)!!.findFirstVisibleItemPosition()
                >= recyclerView.layoutManager!!.itemCount
            ) {
                chatListInterface?.paginateNow()
            }
        }
    }

    @Throws(Exception::class)
    fun init() {
        checkResIds()
        this.setHasFixedSize(false)
        this.isNestedScrollingEnabled = false
        this.addOnScrollListener(mScrollListener)
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        layoutManager.stackFromEnd = false
        layoutManager.isSmoothScrollbarEnabled = false
        adapter = ChatAdapter(selfResId, otherResId, systemResId)
        this.layoutManager = layoutManager
    }

    @Throws(Exception::class)
    private fun checkResIds() {
        if (selfResId == -1)
            throw Exception("Chatkit Error: Chat Bubble SELF ResId Not Provided!")
        if (otherResId == -1)
            throw Exception("Chatkit Error: Chat Bubble OTHER ResId Not Provided!")
        if (systemResId == -1)
            throw Exception("Chatkit Error: Chat Bubble SYSTEM ResId Not Provided!")

    }

    fun newMessageReceived(messageModel: MessageModel) {
        if (::adapter.isInitialized)
            adapter.addNewMessage(messageModel)
    }


}