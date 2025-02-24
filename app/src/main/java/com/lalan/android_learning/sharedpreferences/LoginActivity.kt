package com.lalan.android_learning.sharedpreferences

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lalan.android_learning.R

class Credentials(val username: String, val password: String)

class LoginActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    private fun saveCredentials(credentials: Credentials) {
        val spEditor = getSharedPreferences("credentials", MODE_PRIVATE).edit()
        spEditor.putString("username", credentials.username)
        spEditor.putString("password", credentials.password)
        spEditor.apply()
    }

    private fun checkCredentials(): Boolean {
        val spObject = getSharedPreferences("credentials", MODE_PRIVATE)
        val username: String? = spObject.getString("username", null)
        val password: String? = spObject.getString("password", null)
        return (username != null && password != null)
    }

    private fun openDashboard() {
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        if (checkCredentials()) {
            openDashboard()
        }

        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            if (usernameEditText.text.isEmpty() || passwordEditText.text.isEmpty()) {
                Toast.makeText(this, "Empty fields!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            saveCredentials(
                Credentials(
                    usernameEditText.text.toString(),
                    passwordEditText.text.toString()
                )
            )
            openDashboard()
        }
    }
}