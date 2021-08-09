package com.emad.chatkitcore.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.emad.chatkitcore.R;
import com.emad.chatkitcore.model.MessageModel;

public class ChatMainView extends LinearLayout
        implements View.OnClickListener {

    private ChatListView chatListView;
    private ChatInputView chatInputView;

    private ChatStyle chatStyle;

    public ChatMainView(Context context) {
        super(context);
        initChat(context, null);
    }

    public ChatMainView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initChat(context, attrs);
    }

    private void initChat(Context context, @Nullable AttributeSet attrs) {
        chatStyle = ChatStyle.Parser.parse(context, attrs);
        if(attrs != null){

        }
        initViews(context);
    }

    private void initViews(Context context) {
        View conversationView = LayoutInflater.from(context).inflate(R.layout.chat_main_view, this, true);
        chatListView = conversationView.findViewById(R.id.chatList);
        chatInputView = conversationView.findViewById(R.id.chatInput);
        chatListView.setSelfResId(chatStyle.getSelfResId());
        chatListView.setOtherResId(chatStyle.getOtherResId());
        chatListView.setSystemResId(chatStyle.getSystemResId());
        try {
            chatListView.init();
        } catch (Exception e) {
            Log.e("TAG", "ChatKit3/" + e.getMessage() );
        }
    }

    @Override
    public void onClick(View view) {

    }

    public void newMessageReceived(MessageModel messageModel){
        chatListView.newMessageReceived(messageModel);
    }
}
