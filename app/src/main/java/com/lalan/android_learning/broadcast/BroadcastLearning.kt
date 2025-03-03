package com.lalan.android_learning.broadcast

import android.Manifest
import android.content.Intent
import android.net.ConnectivityManager
import android.net.ConnectivityManager.NetworkCallback
import android.net.Network
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lalan.android_learning.R


class BroadcastLearning : AppCompatActivity() {

    private lateinit var networkStatusTV: TextView
    private lateinit var sendCustomBroadcastButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_broadcast_learning)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        networkStatusTV = findViewById(R.id.networkStatus)
        sendCustomBroadcastButton = findViewById(R.id.sendCustomBroadcastButton)

        val cm = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        cm.registerDefaultNetworkCallback(object : NetworkCallback() {
            override fun onAvailable(network: Network) {
                networkStatusTV.text = "Network: Available!"
            }

            override fun onUnavailable() {
                networkStatusTV.text = "Network: Unavailable!"
            }

            override fun onLost(network: Network) {
                networkStatusTV.text = "Network: Lost"
            }

            override fun onLosing(network: Network, maxMsToLive: Int) {
                networkStatusTV.text = "Network: Losing"
            }
        })


        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.RECEIVE_SMS, Manifest.permission.POST_NOTIFICATIONS),
            1
        );

        sendCustomBroadcastButton.setOnClickListener {
            sendBroadcast(Intent(this, CustomReceiver::class.java).setAction("Custom_Action"))
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        for (result in grantResults) {
            if (result == -1) {
                Toast.makeText(
                    this,
                    "Please provide both notification and sms permission to listen to sms events.",
                    Toast.LENGTH_LONG
                ).show()
                finish()
            }
        }
    }

}