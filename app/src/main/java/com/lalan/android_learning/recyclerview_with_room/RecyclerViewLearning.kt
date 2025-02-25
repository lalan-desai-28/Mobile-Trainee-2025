package com.lalan.android_learning.recyclerview_with_room

import android.os.Bundle
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
import androidx.room.Room
import com.lalan.android_learning.R
import com.lalan.android_learning.recyclerview_with_room.adapters.MessageAdapter
import com.lalan.android_learning.recyclerview_with_room.models.Message
import java.util.Date


class RecyclerViewLearning : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var messageBox: EditText
    private lateinit var receiverButton: ImageButton
    private lateinit var senderButton: ImageButton
    private lateinit var myToolbar: Toolbar
    private lateinit var messageDao: MessageDao
    private lateinit var adapter: MessageAdapter
    private var messageToUpdatePosition: Int = -1
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
        messageToUpdatePosition = position
        changeToolbar(true)
        messageBox.setText(messages[position].message)
        messageBox.setSelection(messages[position].message.length)
    }

    private fun sendMessage(isSender: Boolean) {
        val newMessage =
            Message(message = messageBox.text.toString(), isSender = isSender, dateTime = Date())

        val messageWithID = newMessage.copy(id = messageDao.insert(newMessage).toInt())
        messages.add(messageWithID)

        adapter.notifyItemInserted(messages.size - 1)
        recyclerView.scrollToPosition(messages.size - 1)
        messageBox.setText("")
    }


    private fun editMessage(isSender: Boolean) {
        val oldMessage = messages[messageToUpdatePosition]

        val updatedMessage = oldMessage.copy(
            message = messageBox.text.toString(),
            isSender = isSender,
            dateTime = Date()
        )

        messages[messageToUpdatePosition] = updatedMessage
        messageDao.update(updatedMessage)

        adapter.notifyItemChanged(messageToUpdatePosition)
        messageToUpdatePosition = -1
        messageBox.setText("")
        changeToolbar(false)
    }

    fun deleteMessage(position: Int) {
        val messageToDelete = messages[position]
        messages.removeAt(position)
        messageDao.delete(messageToDelete)
        adapter.notifyItemRemoved(position)

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

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
        messageDao = Room.databaseBuilder(this, MessageDatabase::class.java, "MessageDatabase")
            .allowMainThreadQueries().build().messageDao()

        // Initializing the components.
        recyclerView = findViewById(R.id.recyclerView)
        messageBox = findViewById(R.id.messageBox)
        receiverButton = findViewById(R.id.receiverButton)
        senderButton = findViewById(R.id.senderButton)
        myToolbar = findViewById(R.id.myToolbar)

        messages.addAll(0, messageDao.getAll())
        adapter = MessageAdapter(messages)

        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.scrollToPosition(messages.size - 1)

        receiverButton.setOnClickListener {
            if (messageBox.text.isEmpty())
                return@setOnClickListener

            if (messageToUpdatePosition != -1)
                editMessage(false)
            else
                sendMessage(false)
        }

        senderButton.setOnClickListener {
            if (messageBox.text.isEmpty())
                return@setOnClickListener

            if (messageToUpdatePosition != -1)
                editMessage(true)
            else
                sendMessage(true)
        }

        myToolbar.setNavigationOnClickListener {
            messageBox.setText("")
            messageToUpdatePosition = -1
            changeToolbar(false)
        }

    }
}