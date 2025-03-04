package com.lalan.android_learning.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

class MyBackgroundService : Service() {

    private val retroFit: Retrofit = Retrofit.Builder()
        .baseUrl("https://docs.google.com/forms/u/0/d/e/1FAIpQLSftugDGzXSLSnvZDO-LYoMzIEvEKyBQNDY9Ln0bLEWN69t1zw/")
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()

    private fun createNotification(): Notification {
        val notificationChannelId = "esc"

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val channel = NotificationChannel(
            notificationChannelId,
            "ESC",
            NotificationManager.IMPORTANCE_HIGH
        )

        notificationManager.createNotificationChannel(channel)

        val builder: Notification.Builder = Notification.Builder(
            this,
            notificationChannelId
        )

        return builder.build()
    }

    private fun makePostReq(count: Int) {

        val userServicePost: FormResponseService = retroFit.create(FormResponseService::class.java)

        val call = userServicePost.count("Lalan", count.toString())

        call.enqueue(object : Callback<String> {
            override fun onResponse(p0: Call<String>, p1: Response<String>) {
                Log.d("FormResponse", "onResponse: ${p1.code()} ${p1.raw()} ${p1.body()} ")
                Log.d("FormResponse", "onResponse: Successfully made request with count: $count")
            }

            override fun onFailure(p0: Call<String>, p1: Throwable) {
                throw p1
            }
        })
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val notification = createNotification()
        startForeground(1, notification)

        val mainHandler = Handler(Looper.getMainLooper())

        var lastCount = intent?.extras?.getInt("lastCount") ?: 0

        mainHandler.post(object : Runnable {
            override fun run() {
                makePostReq(lastCount++)
                mainHandler.postDelayed(this, 5000)
            }
        })

        return START_STICKY
    }

    override fun onBind(intent: Intent) = null


}