package com.lalan.android_learning.viewpager.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.lalan.android_learning.R
import com.lalan.android_learning.viewpager.Wallpaper
import com.lalan.android_learning.viewpager.adapters.WallpaperAdapter


class WallpaperFragmentLayout(private val wallpapers: List<Wallpaper>) : Fragment() {

    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_wallpaper_layout, container, false)

        viewPager = view.findViewById(R.id.fragment_view_pager)

        viewPager.offscreenPageLimit = 2

        val adapter = WallpaperAdapter(parentFragmentManager, lifecycle, wallpapers)
        viewPager.adapter = adapter

        return view

    }


}