package com.emad.chatkit3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.emad.chatkitcore.model.MessageModel
import com.emad.chatkitcore.model.MessageSenderEnum
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler().postDelayed(Runnable {
            var messageModel = MessageModel("test")
            messageModel.message = "این یک تست سکسی است"
            messageModel.senderEnum = MessageSenderEnum.SELF
            messageModel.name = "عماد جان"
            messageModel.url = "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"
            chatView.newMessageReceived(messageModel)
        }, 2000)
        Handler().postDelayed(Runnable {
            var messageModel = MessageModel("test2")
            messageModel.message = "این یک تست سکسی دیگر است"
            messageModel.senderEnum = MessageSenderEnum.OTHER
            messageModel.name ="دشمن عماد"
            chatView.newMessageReceived(messageModel)
        }, 3000)
    }
}