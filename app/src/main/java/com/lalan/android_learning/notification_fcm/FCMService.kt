package com.lalan.android_learning.notification_fcm

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.graphics.BitmapFactory
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import java.net.URL


class FCMService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        Log.d("TAG", "Refreshed token: $token")
    }

    private fun getPendingIntent(): PendingIntent {
        val intent = Intent(baseContext.applicationContext, NotificationAndFCMLearning::class.java)
        return PendingIntent.getActivity(
            baseContext.applicationContext,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
    }

    private fun showNotification(message: RemoteMessage) {

        val notification: Notification =
            NotificationCompat.Builder(baseContext.applicationContext, "fcm")
                .setContentTitle(message.notification?.title ?: "Empty!")
                .setContentText(message.notification?.body ?: "Empty!")
                .setContentIntent(getPendingIntent())
                .apply {
                    message.notification?.imageUrl?.let {
                        val image = BitmapFactory.decodeStream(
                            URL(it.toString()).openConnection().getInputStream()
                        )
                        setStyle(NotificationCompat.BigPictureStyle().bigPicture(image))
                    }

                }
                .setVibrate(longArrayOf(500, 500, 500, 500))
                .setAutoCancel(true)
                .build()

        val notificationManager =
            getSystemService(Service.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.notify(1, notification)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        Log.d("TAG", "From: ${message.from}")
        if (message.data.isNotEmpty()) {
            message.notification?.let {
                showNotification(message)
            }
        }
    }
}