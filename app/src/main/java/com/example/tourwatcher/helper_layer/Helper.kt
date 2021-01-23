package com.example.tourwatcher.helper_layer

object Helper {
    const val DEFAULT_TYPE_CHECKED_STATE = false
    const val DEFAULT_ITEM_DIFF_UTIL_VALUE = false

    const val TYPE_POOL = "Пул"
    const val TYPE_PYRAMID = "Пирамида"
    const val TYPE_SNOOKER = "Снукер"
    const val TYPE_CAROM = "Карамболь"
    const val ALL = "Выбрать все"

    const val POOL_8 = "Пул 8"
    const val POOL_9 = "Пул 9"
    const val POOL_10 = "Пул 10"
    const val STRAIGHT_POOL = "Пул 14.1"

    const val RED_6 = "6 красных"
    const val RED_10 = "10 красных"
    const val RED_15 = "15 красных"

    const val CUSHION_2 = "Двухбортный"
    const val CUSHION_3 = "Трёхбортный"

    const val FREE = "Свободная пирамида"
    const val DYNAMIC = "Динамическая пирамида"
    const val COMBINED = "Комбинированная"

    const val KEY_PREFERENCES = "Preferences"
    const val KEY_TYPE = "Type"
    const val KEY_DISCIPLINE = "Discipline"
    const val DEFAULT_SELECTION = false

    const val INDEX_0 = 0
    const val INDEX_1 = 1
    const val INDEX_2 = 2
    const val INDEX_3 = 3

    fun executeOnBackgroundThread(action: () -> Unit) = Thread {
        action()
    }.start()

    fun ArrayList<String>.withAll() = this.apply {
        add(ALL)
    }
}