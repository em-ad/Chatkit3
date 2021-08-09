package com.emad.chatkitcore.view

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.emad.chatkitcore.callback.ChatListInterface

class ChatListView: RecyclerView {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    private var bubbleResId: Int = -1
    private var chatListInterface: ChatListInterface? = null
    private lateinit var adapter: ChatAdapter

    private var mScrollListener: OnScrollListener = object : OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            if (recyclerView.layoutManager == null) return
            if (recyclerView.layoutManager!!.childCount +
                (recyclerView.layoutManager as LinearLayoutManager?)!!.findFirstVisibleItemPosition()
                >= recyclerView.layoutManager!!.itemCount) {
                chatListInterface?.paginateNow()
            }
        }
    }

    public fun setResId(resId: Int){
        this.bubbleResId = resId
    }

    @Throws(Exception::class)
    fun init()  {
        if(bubbleResId == -1)
            throw Exception("Chatkit Error: Chat Bubble Resource Id Not Specified!")
        this.setHasFixedSize(false)
        this.isNestedScrollingEnabled = false
        this.addOnScrollListener(mScrollListener)
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        layoutManager.stackFromEnd = false
        layoutManager.isSmoothScrollbarEnabled = false
        adapter = ChatAdapter(bubbleResId)
        this.layoutManager = layoutManager
    }



}