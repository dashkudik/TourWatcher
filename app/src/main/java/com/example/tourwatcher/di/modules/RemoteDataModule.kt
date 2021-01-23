package com.example.tourwatcher.di.modules

import com.example.tourwatcher.data_layer.data_sources.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule {
    @Provides
    @Singleton
    fun provideRemoteDataSource() = RemoteDataSourceImpl()
}