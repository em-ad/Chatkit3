package com.emad.chatkitcore.view

import android.content.Context
import android.util.AttributeSet
import com.emad.chatkitcore.R

class ChatStyle(context: Context?, attrs: AttributeSet?) : ChatBaseStyle(context, attrs) {

    var selfResId: Int = -1
    var otherResId: Int = -1
    var systemResId: Int = -1

    companion object Parser {
        fun parse(context: Context, attrs: AttributeSet?): ChatStyle {
            val style = ChatStyle(context, attrs)
            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ChatMainView)
            style.selfResId = typedArray.getResourceId(
                R.styleable.ChatMainView_self_res_id,
                -1
            )
            style.otherResId = typedArray.getResourceId(
                R.styleable.ChatMainView_other_res_id,
                -1
            )
            style.systemResId = typedArray.getResourceId(
                R.styleable.ChatMainView_system_res_id,
                -1
            )
            typedArray.recycle()
            return style
        }
    }

}