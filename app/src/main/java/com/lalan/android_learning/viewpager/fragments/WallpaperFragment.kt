package com.lalan.android_learning.viewpager.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.lalan.android_learning.R
import com.lalan.android_learning.viewpager.Wallpaper


class WallpaperFragment(private val wallpaper: Wallpaper) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_wallpaper, container, false)

        val imageView: ImageView = view.findViewById(R.id.image_view)

        imageView.setImageResource(wallpaper.resourceId)

        return view
    }
}