package com.lalan.android_learning.recyclerview.models

import java.time.LocalDateTime

data class Message(val message: String, val isSender: Boolean, val dateTime: LocalDateTime)