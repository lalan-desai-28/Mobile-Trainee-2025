package com.lalan.android_learning.broadcast

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.lalan.android_learning.R


class SMSReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        if (context == null || intent == null)
            return
        
        val notificationChannel =
            NotificationChannel("sms_channel", "SMS Receiver", NotificationManager.IMPORTANCE_HIGH)
        notificationChannel.description = "This channel is for sms events."

        val notification = NotificationCompat.Builder(context)
            .setSmallIcon(R.drawable.sms_24px)
            .setContentTitle("You have a new message!")
            .setChannelId("sms_channel")
            .setAutoCancel(true).build()

        val mNotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        mNotificationManager.createNotificationChannel(notificationChannel)

        mNotificationManager.notify(1, notification)

    }
}