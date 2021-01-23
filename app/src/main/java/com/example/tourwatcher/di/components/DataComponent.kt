package com.example.tourwatcher.di.components

import android.app.Application
import com.example.tourwatcher.data_layer.data_sources.LocalDataSourceImpl
import com.example.tourwatcher.di.modules.LocalDataModule
import com.example.tourwatcher.di.modules.RemoteDataModule
import com.example.tourwatcher.presentation_layer.activity.MainActivity
import com.example.tourwatcher.presentation_layer.filter_fragment.FilterFragment
import com.example.tourwatcher.presentation_layer.filter_fragment.FilterFragmentViewModel
import dagger.Component
import dagger.Provides
import javax.inject.Singleton

@Component(modules = [LocalDataModule::class, RemoteDataModule::class])
@Singleton
interface DataComponent {
    fun inject(activity: MainActivity)
    fun inject(application: Application)
    fun inject(filterFragmentViewModel: FilterFragmentViewModel)
}