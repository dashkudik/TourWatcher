package com.example.tourwatcher

import android.app.Application
import com.example.tourwatcher.data_layer.data_sources.RemoteDataSource
import com.example.tourwatcher.data_layer.data_sources.RemoteDataSourceImpl
import com.example.tourwatcher.data_layer.repositories.NetworkRepository
import com.example.tourwatcher.di.components.*
import com.example.tourwatcher.di.modules.AppModule
import com.example.tourwatcher.di.modules.LocalDataModule
import com.example.tourwatcher.di.modules.NetworkModule
import com.example.tourwatcher.di.modules.RemoteDataModule
import retrofit2.Retrofit
import javax.inject.Inject

class App: Application() {
    companion object {
        lateinit var appComponent: AppComponent
        lateinit var dataComponent: DataComponent
        lateinit var networkComponent: NetworkComponent
    }

    override fun onCreate() {
        super.onCreate()

        val appModule = AppModule(this, this)
        appComponent = DaggerAppComponent
                .builder()
                .appModule(appModule)
                .build()

        val remoteDataModule = RemoteDataModule()
        val localDataModule = LocalDataModule()
        dataComponent = DaggerDataComponent
                .builder()
                .localDataModule(localDataModule)
                .remoteDataModule(remoteDataModule)
                .build()

        val networkModule = NetworkModule(
                Retrofit
                    .Builder()
                    .baseUrl("https://vk.com/")
                    .build(),
                NetworkRepository(RemoteDataSourceImpl())
        )
        networkComponent = DaggerNetworkComponent
                .builder()
                .networkModule(networkModule)
                .build()
    }
}