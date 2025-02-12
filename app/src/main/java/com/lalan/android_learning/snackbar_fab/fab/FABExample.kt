package com.lalan.android_learning.snackbar_fab.fab

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.lalan.android_learning.R

class FABExample : AppCompatActivity() {

    private lateinit var heart_button: FloatingActionButton
    private lateinit var add_button: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fabexample)

        heart_button = findViewById(R.id.heart_button)
        add_button = findViewById(R.id.add_button)

        heart_button.setOnClickListener {
            Toast.makeText(this, "You clicked on the heart fab button.", Toast.LENGTH_SHORT).show()
        }

        add_button.setOnClickListener {
            Toast.makeText(this, "You clicked on the add fab button.", Toast.LENGTH_SHORT).show()
        }

    }
}