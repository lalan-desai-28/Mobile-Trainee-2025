package com.lalan.android_learning

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

import com.lalan.android_learning.activity.ActivityLearning
import com.lalan.android_learning.dimensions.DimensionsLearning
import com.lalan.android_learning.drawable.DrawableActivity
import com.lalan.android_learning.layout.LayoutLearning

class MainActivity : AppCompatActivity() {


    private lateinit var activity_button: Button
    private lateinit var layout_button: Button
    private lateinit var drawable_button: Button
    private lateinit var dimension_button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activity_button = findViewById(R.id.activity_button)
        layout_button = findViewById(R.id.layout_button)
        drawable_button = findViewById(R.id.drawable_button)
        dimension_button = findViewById(R.id.dimension_button)

        activity_button.setOnClickListener {
            val intent = Intent(this, ActivityLearning::class.java)
            startActivity(intent)
        }

        layout_button.setOnClickListener {
            val intent = Intent(this, LayoutLearning::class.java)
            startActivity(intent)
        }

        drawable_button.setOnClickListener {
            val intent = Intent(this, DrawableActivity::class.java)
            startActivity(intent)
        }

        dimension_button.setOnClickListener{
            val intent = Intent(this, DimensionsLearning::class.java)
            startActivity(intent)
        }

    }


}