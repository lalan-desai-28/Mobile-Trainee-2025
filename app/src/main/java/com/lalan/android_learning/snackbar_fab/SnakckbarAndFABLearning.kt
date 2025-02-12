package com.lalan.android_learning.snackbar_fab

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.lalan.android_learning.R
import com.lalan.android_learning.snackbar_fab.fab.FABExample
import com.lalan.android_learning.snackbar_fab.snackbar.SnackbarExamples

class SnakckbarAndFABLearning : AppCompatActivity() {

    private lateinit var snackbar_button: Button
    private lateinit var fab_button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snakckbar_and_fablearning)

        snackbar_button = findViewById(R.id.snackbar_button)
        fab_button = findViewById(R.id.fab_button)

        snackbar_button.setOnClickListener {
            val intent = Intent(this, SnackbarExamples::class.java)
            startActivity(intent)
        }

        fab_button.setOnClickListener {
            val intent = Intent(this, FABExample::class.java)
            startActivity(intent)
        }
    }
}