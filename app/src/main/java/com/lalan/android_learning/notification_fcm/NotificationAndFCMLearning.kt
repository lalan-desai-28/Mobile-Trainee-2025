package com.lalan.android_learning.notification_fcm

import android.Manifest
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lalan.android_learning.R


class NotificationAndFCMLearning : AppCompatActivity() {


    private lateinit var scheduleNotificationButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_notification_and_fcmlearning)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        scheduleNotificationButton = findViewById(R.id.scheduleNotificationButton)

        askNotificationPermission()

        scheduleNotificationButton.setOnClickListener {

            val timeToTrigger = System.currentTimeMillis() + 10 * 1000

            setScheduleNotification(timeToTrigger)

            Toast.makeText(
                this,
                "The notification is scheduled successfully.",
                Toast.LENGTH_SHORT
            ).show()

            finish()
        }
    }

    private fun setScheduleNotification(triggerAtMillis: Long) {
        val fcmIntent =
            Intent(this, Notification::class.java)

        val pendingIntent =
            PendingIntent.getBroadcast(this, 200, fcmIntent, PendingIntent.FLAG_IMMUTABLE)

        val alarmManager = this.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.set(
            AlarmManager.RTC_WAKEUP,
            triggerAtMillis,
            pendingIntent
        )
    }


    private fun askNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) !=
                PackageManager.PERMISSION_GRANTED
            )
                requestPermissions(arrayOf(Manifest.permission.POST_NOTIFICATIONS), 1)
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        for (result in grantResults)
            if (result == -1) {
                Toast.makeText(this, "Please allow the notification permission!", Toast.LENGTH_LONG)
                    .show()
                finish()
            }
    }

}


