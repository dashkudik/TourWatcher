package com.example.tourwatcher.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(
        private val application: Application,
        private val context: Context
) {
    @Provides
    @Singleton
    fun provideApplication() = application

    @Provides
    fun provideContext() = context
}