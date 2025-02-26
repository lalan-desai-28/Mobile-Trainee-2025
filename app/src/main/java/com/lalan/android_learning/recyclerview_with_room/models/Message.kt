package com.lalan.android_learning.recyclerview_with_room.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "messages")
data class Message(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val message: String,
    val isSender: Boolean,
    val dateTime: Date
)