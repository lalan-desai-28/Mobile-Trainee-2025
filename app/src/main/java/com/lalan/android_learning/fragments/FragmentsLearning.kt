package com.lalan.android_learning.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.lalan.android_learning.R
import com.lalan.android_learning.fragments.adapters.FragmentsAdapter
import com.lalan.android_learning.fragments.fragments.FragmentA
import com.lalan.android_learning.fragments.fragments.FragmentB
import com.lalan.android_learning.fragments.fragments.FragmentC

class FragmentsLearning : AppCompatActivity() {

    private lateinit var viewpager: ViewPager2
    private lateinit var tab_layout: TabLayout
    private val fragments: List<Fragment> = listOf(FragmentA(), FragmentB(), FragmentC())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments_learning)

        // Initializing the views
        viewpager = findViewById(R.id.viewpager)
        tab_layout = findViewById(R.id.tab_layout)

        // Inserting the initial data to each fragments
        fragments.forEach { fragment ->
            val bundle = Bundle()
            bundle.putString("data", "Yudiz Solutions Ltd.")
            fragment.setArguments(bundle)
        }

        // Making the adapter for the viewpager.
        val adapter = FragmentsAdapter(supportFragmentManager, lifecycle, fragments)

        viewpager.adapter = adapter

        // Linking both the viewpager and tablayout
        TabLayoutMediator(tab_layout, viewpager, { tab, position ->
            when (position) {
                0 -> tab.text = "Fragment A"
                1 -> tab.text = "Fragment B"
                2 -> tab.text = "Fragment C"
            }
        }).attach()

    }
}