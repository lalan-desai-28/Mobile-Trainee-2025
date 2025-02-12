package com.lalan.android_learning.viewpager

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.lalan.android_learning.R
import com.lalan.android_learning.viewpager.adapters.WallpaperFragmentAdapter
import kotlin.math.log


data class Wallpaper(val resourceId: Int, val type: String)

class ViewPagerActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_pager)


        // Initializing the components
        viewPager = findViewById(R.id.main_view_pager)
        tabLayout = findViewById(R.id.tab_layout)

        // Making the immutable list of wallpapers with distinct 3 types
        val wallpaperList = listOf(
            Wallpaper(R.drawable.art_1, "Art"),
            Wallpaper(R.drawable.art_2, "Art"),
            Wallpaper(R.drawable.art_3, "Art"),
            Wallpaper(R.drawable.art_4, "Art"),

            Wallpaper(R.drawable.vehicle_1, "Vehicle"),
            Wallpaper(R.drawable.vehicle_2, "Vehicle"),
            Wallpaper(R.drawable.vehicle_3, "Vehicle"),
            Wallpaper(R.drawable.vehicle_4, "Vehicle"),

            Wallpaper(R.drawable.wildlife_1, "Wildlife"),
            Wallpaper(R.drawable.wildlife_2, "Wildlife"),
            Wallpaper(R.drawable.wildlife_4, "Wildlife"),
            Wallpaper(R.drawable.wildlife_4, "Wildlife")
        )

        // Making the adapter for the main view pager
        val viewPageAdapter =
            WallpaperFragmentAdapter(supportFragmentManager, lifecycle, wallpaperList)

        viewPager.offscreenPageLimit = 2

        // Attaching it to the main view pager.
        viewPager.adapter = viewPageAdapter

        // Linking both view pager and tab layout with each other
        TabLayoutMediator(tabLayout, viewPager) { tab, index ->
            tab.text = viewPageAdapter.getTitle(index)
        }.attach()


        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            val itemCount = viewPager.adapter?.itemCount ?: -1

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

                if (viewPager.scrollState == ViewPager2.SCROLL_STATE_DRAGGING && viewPager.currentItem == 0 && viewPager.currentItem == position) {
                    viewPager.setCurrentItem(itemCount - 1, true)
                }

                if (viewPager.scrollState == ViewPager2.SCROLL_STATE_DRAGGING && viewPager.currentItem == itemCount - 1 && viewPager.currentItem == position) {
                    viewPager.setCurrentItem(0, true)
                }

                super.onPageScrolled(position, positionOffset, positionOffsetPixels)

            }
        })

    }
}
