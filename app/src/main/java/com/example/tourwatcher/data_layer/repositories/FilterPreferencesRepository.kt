package com.example.tourwatcher.data_layer.repositories

import com.example.tourwatcher.data_layer.data_sources.DataSource
import com.example.tourwatcher.data_layer.data_sources.LocalDataSource
import com.example.tourwatcher.data_layer.objects.Discipline
import com.example.tourwatcher.data_layer.objects.Type
import com.google.android.material.datepicker.SingleDateSelector
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.SingleOnSubscribe
import io.reactivex.schedulers.Schedulers

class FilterPreferencesRepository(private val dataSource: LocalDataSource) {
    fun getTypes(): Single<List<Type>> {
        return Single.just(dataSource.getTypes())
    }
}