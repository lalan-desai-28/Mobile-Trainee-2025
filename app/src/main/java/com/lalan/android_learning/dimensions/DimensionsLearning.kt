package com.lalan.android_learning.dimensions

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lalan.android_learning.R
import com.lalan.android_learning.dimensions.responsive_blog.ResponsiveBlogActivity

class DimensionsLearning : AppCompatActivity() {

    private lateinit var responsive_blog_button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dimensions_learning)

        responsive_blog_button = findViewById(R.id.responsive_blog_button)

        responsive_blog_button.setOnClickListener {
            val intent = Intent(this, ResponsiveBlogActivity::class.java)
            startActivity(intent)
        }

    }
}