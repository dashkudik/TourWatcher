package com.example.tourwatcher.presentation_layer.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentTransaction
import com.example.tourwatcher.App
import com.example.tourwatcher.R
import com.example.tourwatcher.data_layer.data_sources.RemoteDataSource
import com.example.tourwatcher.data_layer.data_sources.RemoteDataSourceImpl
import com.example.tourwatcher.helper_layer.Helper
import com.example.tourwatcher.helper_layer.Helper.INDEX_0
import com.example.tourwatcher.helper_layer.Helper.INDEX_1
import com.example.tourwatcher.helper_layer.Helper.INDEX_2
import com.example.tourwatcher.helper_layer.Helper.INDEX_3
import com.example.tourwatcher.presentation_layer.filter_fragment.FilterFragment
import com.example.tourwatcher.presentation_layer.activity.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject lateinit var remoteDataSource: RemoteDataSourceImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        App.dataComponent.inject(this)
        view_pager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(tab_layout, view_pager) {
                tab, position -> view_pager.setCurrentItem(tab.position, true)
        }.attach()

        tab_layout.getTabAt(INDEX_0)!!.text = getString(R.string.type_pyramid)
        tab_layout.getTabAt(INDEX_1)!!.text = getString(R.string.type_snooker)
        tab_layout.getTabAt(INDEX_2)!!.text = getString(R.string.type_pool)
        tab_layout.getTabAt(INDEX_3)!!.text = getString(R.string.type_carom)

        btn_filter.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.root_layout, FilterFragment()).addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
        }
    }
}