package com.lalan.android_learning.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class CustomReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (context == null || intent == null)
            return

        Toast.makeText(
            context,
            "Custom broadcast received with action: ${intent.action}",
            Toast.LENGTH_LONG
        ).show()
    }
}