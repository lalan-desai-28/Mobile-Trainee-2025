package com.lalan.android_learning.layout.design

import android.os.Bundle
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lalan.android_learning.R

class DesignActivity : AppCompatActivity() {


    private lateinit var red_frame: FrameLayout
    private lateinit var green_frame: FrameLayout
    private lateinit var white_frame: FrameLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_design)

        red_frame = findViewById(R.id.red_frame)
        green_frame = findViewById(R.id.green_frame)
        white_frame = findViewById(R.id.white_frame)


        red_frame.setOnClickListener{
            it.visibility = FrameLayout.GONE
            it.invalidate()
        }

        green_frame.setOnClickListener {
            it.visibility = FrameLayout.GONE
            it.invalidate()
        }

        white_frame.setOnClickListener{
            it.visibility = FrameLayout.GONE
            it.invalidate()
        }

    }
}