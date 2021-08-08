package com.emad.chatkitcore.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.emad.chatkitcore.R;

class ChatMainView extends LinearLayout
        implements View.OnClickListener {

    public ChatMainView(Context context) {
        super(context);
        initChat(context, null);
    }

    private void initChat(Context context, @Nullable AttributeSet attrs) {
        if(attrs != null){

        }
        initViews(context);
    }

    private void initViews(Context context) {
        View conversationView = LayoutInflater.from(context).inflate(R.layout.chat_main_view, this, true);

    }

    public ChatMainView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initChat(context, attrs);
    }

    @Override
    public void onClick(View view) {

    }
}
