package com.lalan.android_learning.intent.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.provider.MediaStore
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lalan.android_learning.R


class AudioIntent : AppCompatActivity() {

    private lateinit var detailsTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_audio_intent)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        detailsTextView = findViewById(R.id.detailsTextView)

        if (intent?.action == Intent.ACTION_SEND) {

            (intent.getParcelableExtra<Parcelable>(Intent.EXTRA_STREAM) as? Uri)?.let {

                val c = contentResolver.query(it, null, null, null, null)
                c!!.moveToFirst()
                val fileName =
                    "File Name: ${c.getString(c.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME))}"
                detailsTextView.text = fileName;

                c.close()

            }
        }
    }
}