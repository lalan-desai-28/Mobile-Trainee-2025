package com.lalan.android_learning

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

import com.lalan.android_learning.activity.ActivityLearning
import com.lalan.android_learning.layout.LayoutLearning

class MainActivity : AppCompatActivity() {


    private lateinit var activity_button: Button
    private lateinit var layout_button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activity_button = findViewById(R.id.activity_button)
        layout_button = findViewById(R.id.layout_button)

        activity_button.setOnClickListener {
            val intent = Intent(this, ActivityLearning::class.java)
            startActivity(intent)
        }

        layout_button.setOnClickListener{
            val intent = Intent(this, LayoutLearning::class.java)
            startActivity(intent)
        }



    }


}