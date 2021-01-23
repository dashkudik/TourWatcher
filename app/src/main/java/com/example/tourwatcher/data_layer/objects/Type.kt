package com.example.tourwatcher.data_layer.objects

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tourwatcher.helper_layer.Helper.DEFAULT_TYPE_CHECKED_STATE
import com.example.tourwatcher.helper_layer.Helper
import com.example.tourwatcher.helper_layer.Helper.ALL
import com.example.tourwatcher.helper_layer.Helper.COMBINED
import com.example.tourwatcher.helper_layer.Helper.CUSHION_2
import com.example.tourwatcher.helper_layer.Helper.CUSHION_3
import com.example.tourwatcher.helper_layer.Helper.DYNAMIC
import com.example.tourwatcher.helper_layer.Helper.FREE
import com.example.tourwatcher.helper_layer.Helper.POOL_10
import com.example.tourwatcher.helper_layer.Helper.POOL_8
import com.example.tourwatcher.helper_layer.Helper.POOL_9
import com.example.tourwatcher.helper_layer.Helper.RED_10
import com.example.tourwatcher.helper_layer.Helper.RED_15
import com.example.tourwatcher.helper_layer.Helper.RED_6
import com.example.tourwatcher.helper_layer.Helper.STRAIGHT_POOL
import com.example.tourwatcher.helper_layer.Helper.TYPE_CAROM
import com.example.tourwatcher.helper_layer.Helper.TYPE_POOL
import com.example.tourwatcher.helper_layer.Helper.TYPE_PYRAMID
import com.example.tourwatcher.helper_layer.Helper.TYPE_SNOOKER

interface IDiscipline {
    val disciplines: Set<String>
}

sealed class Type(
        val name: String,
        val isChecked: Boolean
): IDiscipline {
    companion object {
        fun asArrayList() = arrayListOf(
            TYPE_POOL,
            TYPE_CAROM,
            TYPE_PYRAMID,
            TYPE_SNOOKER
        )
    }
}

class Pool(isChecked: Boolean): Type(name = TYPE_POOL, isChecked) {
    override val disciplines = setOf(POOL_8, POOL_9, POOL_10, STRAIGHT_POOL)
}

class Snooker(isChecked: Boolean): Type(name= TYPE_SNOOKER, isChecked) {
    override val disciplines = setOf(RED_6, RED_10, RED_15)
}

class Carom(isChecked: Boolean): Type(name = TYPE_CAROM, isChecked) {
    override val disciplines = setOf(CUSHION_2, CUSHION_3)
}

class Pyramid(isChecked: Boolean): Type(name = TYPE_PYRAMID, isChecked) {
    override val disciplines = setOf(FREE, DYNAMIC, COMBINED)
}

data class Discipline(val name: String, val type: Type, val isChecked: Boolean)

