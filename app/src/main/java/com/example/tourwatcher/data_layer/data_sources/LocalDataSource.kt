package com.example.tourwatcher.data_layer.data_sources

import com.example.tourwatcher.data_layer.objects.Discipline
import com.example.tourwatcher.data_layer.objects.Type

interface LocalDataSource: DataSource {
    fun getTypes(): List<Type>
    fun setType(type: Type, isChecked: Boolean)
    fun getDisciplines(type: Type): List<Discipline>
    fun setDiscipline(discipline: Discipline, isChecked: Boolean)
}