package com.lalan.android_learning.coil_glide_dark_theme

import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import coil3.load
import coil3.request.crossfade
import coil3.request.transformations
import coil3.transform.CircleCropTransformation
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.lalan.android_learning.R

class CoilGlideDarkThemeLearning : AppCompatActivity() {

    private lateinit var themeRadioGroup: RadioGroup
    private lateinit var coilImageView: ImageView
    private lateinit var glideImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_coil_glide_dark_theme_learning)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        coilImageView = findViewById(R.id.coilImageView)
        glideImageView = findViewById(R.id.glideImageView)
        themeRadioGroup = findViewById(R.id.themeRadioGroup)

        themeRadioGroup.setOnCheckedChangeListener { _, i ->
            changeTheme(themeRadioGroup.checkedRadioButtonId)
        }

        coilImageView.load(
            "https://miro.medium.com/v2/resize:fit:1200/1*F8aymrD8vHCfS5zDyDZN7g.jpeg"
        )

        Glide.with(this)
            .load("https://github.com/bumptech/glide/blob/master/static/glide_logo.png?raw=true")
            .placeholder(R.drawable.error_24px)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(glideImageView)
    }

    private fun changeTheme(checkedRadioButtonId: Int) {
        AppCompatDelegate.setDefaultNightMode(
            when (checkedRadioButtonId) {
                R.id.lightRadioButton -> AppCompatDelegate.MODE_NIGHT_NO
                R.id.darkRadioButton -> AppCompatDelegate.MODE_NIGHT_YES
                else -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
            }
        )
    }

}