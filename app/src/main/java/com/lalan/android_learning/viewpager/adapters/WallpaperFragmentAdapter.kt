package com.lalan.android_learning.viewpager.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.lalan.android_learning.viewpager.Wallpaper
import com.lalan.android_learning.viewpager.WallpaperFragmentLayout

class WallpaperFragmentAdapter(
    fragmentActivity: FragmentActivity,
    private val wallpaperList: List<Wallpaper>
) : FragmentStateAdapter(fragmentActivity) {

    private val fragments = mutableListOf<Fragment>()

    val genreSeperatedList = wallpaperList.groupBy { it.type }

    init {
        genreSeperatedList.forEach { s, wallpapers ->
            fragments.add(WallpaperFragmentLayout(s, wallpapers))
        }
    }

    override fun getItemCount(): Int {
        return wallpaperList.groupBy { it.type }.count()
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

}