package com.lalan.android_learning.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.lalan.android_learning.R


class WallpaperFragmentLayout(s: String, wallpapers: List<Wallpaper>) : Fragment() {

    private lateinit var fragment_view_pager : ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        fragment_view_pager = context.findViewById(R.id.fragment_view_pager)
        return inflater.inflate(R.layout.fragment_wallpaper_layout, container, false)
    }


}