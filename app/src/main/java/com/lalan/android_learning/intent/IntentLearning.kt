package com.lalan.android_learning.intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lalan.android_learning.R
import com.lalan.android_learning.intent.activities.AudioIntent
import com.lalan.android_learning.intent.activities.ImageIntent

class IntentLearning : AppCompatActivity() {

    private lateinit var audioActivityButton: Button
    private lateinit var imageActivityButton: Button
    private lateinit var openLinkButton: Button
    private lateinit var callButton: Button
    private lateinit var sendMailButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_intent_learning)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        audioActivityButton = findViewById(R.id.audioActivityButton)
        imageActivityButton = findViewById(R.id.imageActivityButton)
        openLinkButton = findViewById(R.id.openLinkButton)
        callButton = findViewById(R.id.callButton)
        sendMailButton = findViewById(R.id.sendMailButton)

        audioActivityButton.setOnClickListener {
            val intent = Intent(this, AudioIntent::class.java)
            startActivity(intent)
        }

        imageActivityButton.setOnClickListener {
            val intent = Intent(this, ImageIntent::class.java)
            startActivity(intent)
        }

        openLinkButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://yudiz.com"))
            startActivity(intent)
        }

        callButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+919876543210"))
            startActivity(intent)
        }

        sendMailButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.setData(Uri.parse("mailto:"))
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("customer@gmail.com"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Order conformation | #324234")
            intent.putExtra(
                Intent.EXTRA_TEXT,
                "Dear Customer,\n\nYour order of fresh fruits is confirmed with order id #324234.\n\nThanks."
            )
            val shareIntent = Intent.createChooser(intent, "Select an email app...")
            startActivity(shareIntent)
        }
    }
}