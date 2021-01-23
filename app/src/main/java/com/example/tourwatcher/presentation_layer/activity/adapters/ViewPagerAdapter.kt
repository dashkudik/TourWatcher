package com.example.tourwatcher.presentation_layer.activity.adapters

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tourwatcher.presentation_layer.tourlist_fragment.TourListFragment

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount() = 4
    override fun createFragment(position: Int) = TourListFragment()
}