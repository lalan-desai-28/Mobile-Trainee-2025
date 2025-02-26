package com.lalan.android_learning.recyclerview_with_room.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.lalan.android_learning.R
import com.lalan.android_learning.recyclerview_with_room.RecyclerViewLearning
import com.lalan.android_learning.recyclerview_with_room.models.Message
import java.text.SimpleDateFormat


class MessageAdapter(private val messages: MutableList<Message>) :
    RecyclerView.Adapter<MessageAdapter.ViewHolder>() {

    private lateinit var context: Context

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val messageTextview: TextView = view.findViewById(R.id.messageTextview)
        val timeTextView: TextView = view.findViewById(R.id.timeTextView)
        val messageLayout: RelativeLayout = view.findViewById(R.id.messageLayout)
        val messageCardView: CardView = view.findViewById(R.id.messageCardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.message_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = messages.size

    override fun onBindViewHolder(holder: ViewHolder, itemPosition: Int) {

        val message = messages[itemPosition]

        if (!message.isSender) {
            val params = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            )
            params.addRule(RelativeLayout.ALIGN_END)

            holder.messageLayout.layoutParams = params
            holder.messageCardView.setCardBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.black
                )
            )
            holder.messageTextview.setTextColor(ContextCompat.getColor(context, R.color.white))
            holder.timeTextView.setTextColor(ContextCompat.getColor(context, R.color.white))
        } else {
            val params = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            )
            params.addRule(RelativeLayout.ALIGN_PARENT_END)

            holder.messageLayout.layoutParams = params
            holder.messageCardView.setCardBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.white
                )
            )
            holder.messageTextview.setTextColor(ContextCompat.getColor(context, R.color.black))
            holder.timeTextView.setTextColor(ContextCompat.getColor(context, R.color.black))
        }

        holder.messageTextview.text = message.message
        holder.timeTextView.text = SimpleDateFormat("hh:mm:ss").format(message.dateTime)

        holder.itemView.setOnLongClickListener {
            MaterialAlertDialogBuilder(context).setTitle("Select an option").setItems(
                arrayOf("Edit", "Delete"),
            ) { _, index ->
                if (index == 0) {
                    // edit
                    (context as RecyclerViewLearning).setEditMessage(itemPosition)
                } else {
                    //delete
                    (context as RecyclerViewLearning).deleteMessage(message)
                    notifyItemRemoved(itemPosition)
                }
            }.show()
            true
        }

    }
}