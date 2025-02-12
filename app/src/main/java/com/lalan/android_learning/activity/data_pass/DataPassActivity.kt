package com.lalan.android_learning.activity.data_pass

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.lalan.android_learning.R


class DataPassActivity : AppCompatActivity() {

    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val message = data?.getStringExtra("message")
                Toast.makeText(this, "Message from child: $message", Toast.LENGTH_SHORT).show()
            }
        }

    private lateinit var activity_data_pass: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_pass)

        // initializing buttons from view.
        activity_data_pass = findViewById(R.id.data_pass_button)

        activity_data_pass.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            resultLauncher.launch(intent)
        }
    }
}