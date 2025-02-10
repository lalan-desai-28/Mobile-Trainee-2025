package com.lalan.android_learning.viewpager.adapters

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.lalan.android_learning.viewpager.Wallpaper
import com.lalan.android_learning.viewpager.fragments.WallpaperFragmentLayout

class WallpaperFragmentAdapter(
    manager: FragmentManager,
    lifecycle: Lifecycle,
    wallpapers: List<Wallpaper>
) : FragmentStateAdapter(manager, lifecycle) {

    private val genreSeparatedList = wallpapers.shuffled().groupBy { it.type }

    override fun getItemCount(): Int {
        return genreSeparatedList.size
    }

    override fun createFragment(position: Int): Fragment {
        val genre = genreSeparatedList.keys.toList()[position]
        val wallpaperForGenre = genreSeparatedList.getValue(genre)
        return WallpaperFragmentLayout(wallpaperForGenre)
    }

    fun getTitle(position: Int): String {
        return genreSeparatedList.keys.toList()[position]
    }

}