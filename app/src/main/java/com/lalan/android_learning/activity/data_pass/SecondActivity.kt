package com.lalan.android_learning.activity.data_pass

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lalan.android_learning.R

class SecondActivity : AppCompatActivity() {

    private lateinit var pass_data_to_parent_button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // initializing buttons from views.
        pass_data_to_parent_button = findViewById(R.id.pass_data_to_parent_button)

        pass_data_to_parent_button.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("message", "Yudiz Solutions Ltd.")
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}