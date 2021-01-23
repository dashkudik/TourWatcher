package com.example.tourwatcher.data_layer.data_sources

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.graphics.Insets.add
import com.example.tourwatcher.App
import com.example.tourwatcher.App.Companion.appComponent
import com.example.tourwatcher.data_layer.objects.*
import com.example.tourwatcher.helper_layer.Helper
import com.example.tourwatcher.helper_layer.Helper.DEFAULT_SELECTION
import com.example.tourwatcher.helper_layer.Helper.KEY_DISCIPLINE
import com.example.tourwatcher.helper_layer.Helper.KEY_PREFERENCES
import com.example.tourwatcher.helper_layer.Helper.KEY_TYPE
import com.example.tourwatcher.helper_layer.Helper.TYPE_CAROM
import com.example.tourwatcher.helper_layer.Helper.TYPE_POOL
import com.example.tourwatcher.helper_layer.Helper.TYPE_PYRAMID
import com.example.tourwatcher.helper_layer.Helper.TYPE_SNOOKER
import javax.inject.Inject

class LocalDataSourceImpl: LocalDataSource {
    @Inject lateinit var context: Context
    private val preferences: SharedPreferences

    init {
        appComponent.inject(this)
        preferences = context.getSharedPreferences(KEY_PREFERENCES, MODE_PRIVATE)
    }

    override fun getTypes(): List<Type> {
        return ArrayList<Type>().apply {
            add(Pool(isChecked(KEY_TYPE + TYPE_POOL)))
            add(Snooker(isChecked(KEY_TYPE + TYPE_SNOOKER)))
            add(Pyramid(isChecked(KEY_TYPE + TYPE_PYRAMID)))
            add(Carom(isChecked(KEY_TYPE + TYPE_CAROM)))
        }
    }

    override fun setType(type: Type, isChecked: Boolean) {
        preferences
                .edit()
                .putBoolean(KEY_TYPE + type.name, isChecked)
                .apply()
    }

    override fun getDisciplines(type: Type): List<Discipline> {
        return ArrayList<Discipline>().apply {
            type.disciplines.forEach { name ->
                add(Discipline(name, type, isChecked(KEY_DISCIPLINE + name)))
            }
        }
    }

    override fun setDiscipline(discipline: Discipline, isChecked: Boolean) {
        preferences
                .edit()
                .putBoolean(KEY_DISCIPLINE + discipline.name, isChecked)
                .apply()
    }

    private fun isChecked(key: String): Boolean {
        return preferences.getBoolean(key, DEFAULT_SELECTION)
    }
}