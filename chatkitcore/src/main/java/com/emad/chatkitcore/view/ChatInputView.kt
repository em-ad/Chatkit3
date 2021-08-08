package com.emad.chatkitcore.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import com.emad.chatkitcore.R

public class ChatInputView : RelativeLayout, View.OnClickListener {
    constructor(context: Context) : super(context) {
        initChat(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initChat(context, attrs)
    }

    private fun initChat(context: Context, attrs: AttributeSet?) {
        if (attrs != null) {

        }
        initViews(context)
    }

    private fun initViews(context: Context) {
        val inputView: View =
            LayoutInflater.from(context).inflate(R.layout.chat_input_view, this, true)
    }

    override fun onClick(view: View) {

    }
}