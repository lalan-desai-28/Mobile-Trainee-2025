package com.lalan.android_learning.dependency_injection.task_one.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lalan.android_learning.R
import com.lalan.android_learning.dependency_injection.task_one.data.model.Todo

class TodoRecyclerViewAdapter(private val todos: List<Todo>) :
    RecyclerView.Adapter<TodoRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextview: TextView = itemView.findViewById(R.id.titleTextview)
        val isCompletedCheckbox: CheckBox = itemView.findViewById(R.id.isCompletedCheckbox)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.todo_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleTextview.text = todos[position].title
        holder.isCompletedCheckbox.isChecked = todos[position].completed
    }

    override fun getItemCount() = todos.count()
}