package com.lalan.android_learning.recyclerview

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lalan.android_learning.R
import com.lalan.android_learning.recyclerview.adapters.MessageAdapter
import com.lalan.android_learning.recyclerview.models.Message
import java.time.LocalDateTime


class RecyclerViewLearning : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var messageBox: EditText
    private lateinit var receiverButton: ImageButton
    private lateinit var senderButton: ImageButton
    private lateinit var myToolbar: Toolbar

    private lateinit var adapter: MessageAdapter


    private var messageToUpdate = -1

    private val messages: MutableList<Message> = mutableListOf()

    fun setEditMessage(position: Int) {
        myToolbar.visibility = View.VISIBLE
        val msg = messages[position]
        messageBox.setText(msg.message)
        messageBox.setSelection(msg.message.length)
        messageToUpdate = position
    }

    private fun sendMessage(isSender: Boolean) {
        val newMessage = Message(messageBox.text.toString(), isSender, LocalDateTime.now())
        messages.add(newMessage)
        adapter.notifyItemInserted(messages.size - 1)
        recyclerView.scrollToPosition(messages.size - 1)
        messageBox.setText("")
    }

    private fun editMessage(isSender: Boolean) {
        val updatedMessage =
            Message(messageBox.text.toString(), isSender, messages[messageToUpdate].dateTime)
        messages[messageToUpdate] = updatedMessage
        adapter.notifyItemChanged(messageToUpdate)
        messageToUpdate = -1
        messageBox.setText("")
        myToolbar.visibility = View.GONE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view_learning)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        // Initializing the components.
        recyclerView = findViewById(R.id.recyclerView)
        messageBox = findViewById(R.id.messageBox)
        receiverButton = findViewById(R.id.receiverButton)
        senderButton = findViewById(R.id.senderButton)
        myToolbar = findViewById(R.id.myToolbar)

        adapter = MessageAdapter(messages)

        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(this)

        receiverButton.setOnClickListener {

            if (messageBox.text.length < 1)
                Toast.makeText(this, "Message can not be empty!", Toast.LENGTH_SHORT).show()

            if (messageToUpdate != -1) {
                editMessage(false)
                return@setOnClickListener
            }

            sendMessage(false)
        }

        senderButton.setOnClickListener {

            if (messageBox.text.length < 1)
                Toast.makeText(this, "Message can not be empty!", Toast.LENGTH_SHORT).show()

            if (messageToUpdate != -1) {
                editMessage(true)
                return@setOnClickListener
            }

            sendMessage(true)
        }


        myToolbar.setNavigationOnClickListener {
            messageBox.setText("")
            messageToUpdate = -1
            myToolbar.visibility = View.GONE
        }


    }


}