package com.lalan.android_learning.recyclerview.adapters

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
import com.lalan.android_learning.recyclerview.RecyclerViewLearning
import com.lalan.android_learning.recyclerview.models.Message
import java.time.format.DateTimeFormatter


class MessageAdapter(private val messages: MutableList<Message>) :
    RecyclerView.Adapter<MessageAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

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
        }

        holder.messageTextview.text = message.message
        holder.timeTextView.text = message.dateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"))

        holder.messageCardView.setOnLongClickListener {
            MaterialAlertDialogBuilder(context).setTitle("Select an option").setItems(
                arrayOf("Edit", "Delete"),
            ) { _, index ->
                if (index == 0) {
                    // edit
                    (context as RecyclerViewLearning).setEditMessage(itemPosition)
                } else {
                    //delete
                    messages.removeAt(itemPosition)
                    notifyItemRemoved(itemPosition)
                }
            }.show()
            true
        }
    }
}