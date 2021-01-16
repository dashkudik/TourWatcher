package com.example.tourwatcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view_pager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(tab_layout, view_pager) {
                tab, position -> view_pager.setCurrentItem(tab.position, true) }.attach()

        tab_layout.getTabAt(0)!!.text = "Пирамида"
        tab_layout.getTabAt(1)!!.text = "Снукир"
        tab_layout.getTabAt(2)!!.text = "Пул"
        tab_layout.getTabAt(3)!!.text = "Карамболь"

    }
}