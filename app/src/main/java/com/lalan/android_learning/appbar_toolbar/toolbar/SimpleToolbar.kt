package com.lalan.android_learning.appbar_toolbar.toolbar

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.lalan.android_learning.R

class SimpleToolbar : AppCompatActivity() {

    private lateinit var my_toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_toolbar)

        my_toolbar = findViewById(R.id.my_toolbar)

        my_toolbar.setOnMenuItemClickListener {
            Toast.makeText(this, "You clicked on the ${it.title} button.", Toast.LENGTH_SHORT)
                .show()
            true
        }

        my_toolbar.setNavigationOnClickListener {
            Toast.makeText(this, "You clicked on the navigation icon.", Toast.LENGTH_SHORT).show()
        }
    }
}