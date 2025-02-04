package com.lalan.android_learning.layout.signup

import android.app.DatePickerDialog
import android.os.Bundle
import android.provider.Settings.Global
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.transition.Visibility
import com.lalan.android_learning.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SignUpActivity : AppCompatActivity() {

    private lateinit var submitButton: Button
    private lateinit var progress_bar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        submitButton = findViewById(R.id.submitButton)
        progress_bar = findViewById(R.id.progress_bar)

        submitButton.setOnClickListener {
            submitButton.visibility = Button.GONE
            progress_bar.visibility = ProgressBar.VISIBLE

            GlobalScope.launch {
                delay(5000)
                finish()
            }
        }
    }
}