package com.lalan.android_learning.viewpager.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.lalan.android_learning.viewpager.Wallpaper
import com.lalan.android_learning.viewpager.fragments.WallpaperFragment

class WallpaperAdapter(
    manager: FragmentManager,
    lifecycle: Lifecycle,
    private val wallpapers: List<Wallpaper>
) : FragmentStateAdapter(manager, lifecycle) {

    override fun getItemCount(): Int {
        return wallpapers.size
    }

    override fun createFragment(position: Int): Fragment {
        return WallpaperFragment(wallpapers[position])
    }

}