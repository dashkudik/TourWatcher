package com.example.tourwatcher.di.modules

import com.example.tourwatcher.data_layer.data_sources.LocalDataSourceImpl
import com.example.tourwatcher.data_layer.repositories.FilterPreferencesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Provides
    fun provideFilterPreferencesRepository() = FilterPreferencesRepository(LocalDataSourceImpl())
}