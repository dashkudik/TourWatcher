package com.example.tourwatcher.di.components

import com.example.tourwatcher.di.modules.NetworkModule
import com.example.tourwatcher.presentation_layer.tourlist_fragment.TourListFragment
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface NetworkComponent {
    fun inject(tourListFragment: TourListFragment)
}