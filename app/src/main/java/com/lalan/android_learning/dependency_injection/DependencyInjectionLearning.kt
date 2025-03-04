package com.lalan.android_learning.dependency_injection

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lalan.android_learning.R
import com.lalan.android_learning.dependency_injection.task_two.DITaskTwoActivity
import com.lalan.android_learning.dependency_injection.task_one.DITaskOneActivity


class DependencyInjectionLearning : AppCompatActivity() {

    private lateinit var task1Button: Button
    private lateinit var task2Button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_dependency_injection_learning)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        task1Button = findViewById(R.id.task1Button)
        task2Button = findViewById(R.id.task2Button)

        task1Button.setOnClickListener {
            val intent = Intent(this, DITaskOneActivity::class.java)
            startActivity(intent)
        }

        task2Button.setOnClickListener {
            val intent = Intent(this, DITaskTwoActivity::class.java)
            startActivity(intent)
        }

    }
}