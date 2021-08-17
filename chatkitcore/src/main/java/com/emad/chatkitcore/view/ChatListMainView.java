package com.emad.chatkitcore.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.emad.chatkitcore.R;
import com.emad.chatkitcore.callback.ChatInputInterface;
import com.emad.chatkitcore.callback.ChatInterface;
import com.emad.chatkitcore.callback.ChatListInterface;
import com.emad.chatkitcore.model.MessageModel;

import org.jetbrains.annotations.NotNull;

public class ChatListMainView extends LinearLayout
        implements View.OnClickListener, ChatInputInterface, ChatListInterface {

    private ChatListView chatListView;
    private ChatInputView chatInputView;
    private ChatInterface chatInterface;
    private ChatStyle chatStyle;

    public ChatListMainView(Context context) {
        super(context);
        initChat(context, null);
    }

    public ChatListMainView(Context context, @Nullable AttributeSet attrs) {
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
        chatListView.setChatInterface(this);
        chatInputView = conversationView.findViewById(R.id.chatInput);
        chatInputView.setChatInputInterface(this);
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

    public void setChatInterface(ChatInterface chatInterface){
        this.chatInterface = chatInterface;
    }

    @Override
    public void messageSubmitted(@NotNull String text) {
        this.chatInterface.sendMessage(text);
    }

    @Override
    public void paginateNow() {
        this.chatInterface.paginateNow();
    }
}
