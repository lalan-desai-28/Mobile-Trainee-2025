package com.lalan.android_learning.retrofit.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lalan.android_learning.R
import com.lalan.android_learning.retrofit.models.User

class UserAdapter(private val users: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {


    class ViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextview: TextView = itemView.findViewById(R.id.nameTextview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.user_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        val user = users[position]
        holder.nameTextview.text = user.name
    }

    override fun getItemCount() = users.size

}