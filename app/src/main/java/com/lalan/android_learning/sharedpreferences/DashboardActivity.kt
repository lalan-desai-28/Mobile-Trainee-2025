package com.lalan.android_learning.sharedpreferences

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lalan.android_learning.R

class DashboardActivity : AppCompatActivity() {

    private lateinit var welcomeTextView: TextView
    private lateinit var logoutButton: Button

    private fun getCredentials(): Credentials? {
        val spObject = getSharedPreferences("credentials", MODE_PRIVATE)
        val username: String? = spObject.getString("username", null)
        val password: String? = spObject.getString("password", null)
        return if (username != null && password != null) {
            return Credentials(username, password)
        } else
            null
    }

    private fun deleteCredentials() {
        getSharedPreferences("credentials", MODE_PRIVATE).edit().clear().apply()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        welcomeTextView = findViewById(R.id.welcomeTextView)
        logoutButton = findViewById(R.id.logoutButton)

        val credentials = getCredentials()

        if (credentials == null) {
            Toast.makeText(this, "We had some error!", Toast.LENGTH_LONG).show()
            finish()
            return
        }

        val msg = "Welcome, ${credentials.username}"
        welcomeTextView.text = msg

        logoutButton.setOnClickListener {
            deleteCredentials()
            Toast.makeText(this, "Logged out successfully!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}