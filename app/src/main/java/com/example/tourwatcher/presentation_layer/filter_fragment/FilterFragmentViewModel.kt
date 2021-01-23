package com.example.tourwatcher.presentation_layer.filter_fragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.tourwatcher.App
import com.example.tourwatcher.App.Companion.dataComponent
import com.example.tourwatcher.data_layer.objects.Type
import com.example.tourwatcher.data_layer.repositories.FilterPreferencesRepository
import com.example.tourwatcher.helper_layer.Helper
import com.example.tourwatcher.helper_layer.Helper.DEFAULT_SELECTION
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FilterFragmentViewModel(app: Application): AndroidViewModel(app) {
    @Inject lateinit var filterPreferencesRepository: FilterPreferencesRepository

    init {
        dataComponent.inject(this)
    }

    internal val typeLiveData = MutableLiveData<List<Type>?>().apply {
        value = listOf()
    }

    fun getTypes() {
        filterPreferencesRepository
            .getTypes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ types ->
                typeLiveData.value = types
            }, { types ->
                typeLiveData.value = null
            })
    }
}