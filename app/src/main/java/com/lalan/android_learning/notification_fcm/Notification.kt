package com.lalan.android_learning.notification_fcm

import android.annotation.SuppressLint
import android.app.Notification
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.lalan.android_learning.R


class Notification : BroadcastReceiver() {
    @SuppressLint("MissingPermission")
    override fun onReceive(context: Context, intent2: Intent) {

        val notification: Notification =
            NotificationCompat.Builder(context, "scheduled_notification")
                .setSmallIcon(R.drawable.circular_ring)
                .setContentTitle("Scheduled notification!")
                .setContentText("This is a scheduled notification.")
                .setVibrate(longArrayOf(500, 500, 500, 500))
                .setAutoCancel(true)
                .build()

        NotificationManagerCompat.from(context).notify(200, notification)

    }


}