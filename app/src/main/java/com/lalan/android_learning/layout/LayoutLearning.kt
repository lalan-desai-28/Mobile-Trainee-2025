package com.lalan.android_learning.layout

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lalan.android_learning.R
import com.lalan.android_learning.layout.design.DesignActivity
import com.lalan.android_learning.layout.profile.ProfileActivity
import com.lalan.android_learning.layout.signup.SignUpActivity

class LayoutLearning : AppCompatActivity() {

    private lateinit var signup_from_button : Button
    private lateinit var edit_profile_button : Button
    private lateinit var design_form_button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_learning)

        // initializing buttons.
        signup_from_button = findViewById(R.id.signup_from_button)
        edit_profile_button = findViewById(R.id.edit_profile_button)
        design_form_button = findViewById(R.id.design_form_button)

        signup_from_button.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        edit_profile_button.setOnClickListener{
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        design_form_button.setOnClickListener{
            val intent = Intent(this, DesignActivity::class.java)
            startActivity(intent)
        }

    }
}