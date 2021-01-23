package com.example.tourwatcher.di.components

import com.example.tourwatcher.data_layer.data_sources.LocalDataSourceImpl
import com.example.tourwatcher.data_layer.data_sources.RemoteDataSourceImpl
import com.example.tourwatcher.di.modules.AppModule
import com.example.tourwatcher.di.modules.NetworkModule
import com.example.tourwatcher.presentation_layer.filter_fragment.FilterFragment
import com.example.tourwatcher.presentation_layer.tourlist_fragment.TourListFragment
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {
    fun inject(tourListFragment: TourListFragment)
    fun inject(filterFragment: FilterFragment)
    fun inject(localDataSourceImpl: LocalDataSourceImpl)
}