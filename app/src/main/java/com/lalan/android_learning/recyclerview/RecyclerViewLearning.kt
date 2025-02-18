package com.lalan.android_learning.recyclerview

import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.EditText
import android.widget.ImageButton
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

    private fun changeToolbar(isEditing: Boolean) {
        if (isEditing) {
            myToolbar.title = "Editing message"
            myToolbar.setNavigationIcon(R.drawable.close_24px)
        } else {
            myToolbar.title = "Chat"
            myToolbar.navigationIcon = null
        }
    }

    fun setEditMessage(position: Int) {
        Log.d("TAG", "setEditMessage: $position")
        messageToUpdate = position
        changeToolbar(true)
        val msg = messages[messageToUpdate]
        messageBox.setText(msg.message)
        messageBox.setSelection(msg.message.length)
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
            Message(messageBox.text.toString(), isSender, LocalDateTime.now())
        messages[messageToUpdate] = updatedMessage
        adapter.notifyItemChanged(messageToUpdate)
        messageToUpdate = -1
        messageBox.setText("")
        changeToolbar(false)
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
        adapter.setHasStableIds(true)

        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(this)

        receiverButton.setOnClickListener {

            if (messageBox.text.isEmpty())
                return@setOnClickListener

            if (messageToUpdate != -1)
                editMessage(false)
            else
                sendMessage(false)

        }

        senderButton.setOnClickListener {

            if (messageBox.text.isEmpty())
                return@setOnClickListener

            if (messageToUpdate != -1)
                editMessage(true)
            else
                sendMessage(true)

        }


        myToolbar.setNavigationOnClickListener {
            messageBox.setText("")
            messageToUpdate = -1
            changeToolbar(false)
        }

    }
}