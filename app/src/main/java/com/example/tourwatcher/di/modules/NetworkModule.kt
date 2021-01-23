package com.example.tourwatcher.di.modules

import com.example.tourwatcher.data_layer.repositories.NetworkRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetworkModule(
    private val networkService: Retrofit,
    private val networkRepository: NetworkRepository
) {
    @Provides
    @Singleton
    fun provideNetworkService() = networkService

    @Provides
    @Singleton
    fun provideRepository() = networkRepository
}