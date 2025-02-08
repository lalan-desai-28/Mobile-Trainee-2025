package com.lalan.android_learning.viewpager

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.lalan.android_learning.R
import com.lalan.android_learning.viewpager.adapters.WallpaperFragmentAdapter

class ViewPagerActivity : AppCompatActivity() {

    private lateinit var main_view_pager: ViewPager2
    private lateinit var tab_layout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_pager)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initializing the comps.
        main_view_pager = findViewById(R.id.main_view_pager)
        tab_layout = findViewById(R.id.tab_layout)

        val wallpaperList = listOf(
            Wallpaper("wallpaper (1)", "Nature"),
            Wallpaper("wallpaper (2)", "Car"),
            Wallpaper("wallpaper (3)", "Nature"),
            Wallpaper("wallpaper (4)", "Car"),
            Wallpaper("wallpaper (5)", "Bike"),
            Wallpaper("wallpaper (6)", "Bike"),
            Wallpaper("wallpaper (7)", "Bike"),
            Wallpaper("wallpaper (8)", "Car"),
            Wallpaper("wallpaper (9)", "Bike"),
            Wallpaper("wallpaper (10)", "Nature")
        )


        main_view_pager.adapter = WallpaperFragmentAdapter(this, wallpaperList)




    }
}