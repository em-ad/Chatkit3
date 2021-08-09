package com.emad.chatkit3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.emad.chatkitcore.model.MessageModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler().postDelayed(Runnable {
            var messageModel = MessageModel("test")
            messageModel.message = "این یک تست سکسی است"
            chatView.newMessageReceived(messageModel)
        }, 2000)
    }
}