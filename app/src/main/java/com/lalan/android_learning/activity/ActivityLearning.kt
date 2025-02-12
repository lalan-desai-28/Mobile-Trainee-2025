package com.lalan.android_learning.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lalan.android_learning.R
import com.lalan.android_learning.activity.data_pass.DataPassActivity
import com.lalan.android_learning.activity.lifecycle.LifeCycleActivity

class ActivityLearning : AppCompatActivity() {

    private lateinit var activity_lifecycle_button: Button
    private lateinit var activity_data_pass: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_learning)

        // initializing buttons from views.
        activity_lifecycle_button = findViewById(R.id.activity_lifecycle_button)
        activity_data_pass = findViewById(R.id.activity_data_pass)

        activity_lifecycle_button.setOnClickListener {
            val intent = Intent(this, LifeCycleActivity::class.java)
            startActivity(intent)
        }

        activity_data_pass.setOnClickListener {
            val intent = Intent(this, DataPassActivity::class.java)
            startActivity(intent)
        }
    }
}