package com.lalan.android_learning.appbar_toolbar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.lalan.android_learning.R
import com.lalan.android_learning.appbar_toolbar.actionbar.SimpleActionBar
import com.lalan.android_learning.appbar_toolbar.collapsing.CollapsingToolbarAndCoordinatorLayout
import com.lalan.android_learning.appbar_toolbar.toolbar.SimpleToolbar

class AppbarToolbarLearning : AppCompatActivity() {

    private lateinit var simple_action_bar_button: Button
    private lateinit var simple_tool_bar_button: Button
    private lateinit var collapsing_toolbar_coordinatorlayout_button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appbar_toolbar_learning)

        simple_action_bar_button = findViewById(R.id.simple_action_bar_button)
        simple_tool_bar_button = findViewById(R.id.simple_tool_bar_button)
        collapsing_toolbar_coordinatorlayout_button = findViewById(R.id.collapsing_toolbar_coordinatorlayout_button)

        simple_action_bar_button.setOnClickListener {
            val intent = Intent(this, SimpleActionBar::class.java)
            startActivity(intent)
        }

        simple_tool_bar_button.setOnClickListener {
            val intent = Intent(this, SimpleToolbar::class.java)
            startActivity(intent)
        }

        collapsing_toolbar_coordinatorlayout_button.setOnClickListener {
            val intent = Intent(this, CollapsingToolbarAndCoordinatorLayout::class.java)
            startActivity(intent)
        }

    }
}