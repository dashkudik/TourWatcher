package com.example.tourwatcher.presentation_layer.filter_fragment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.tourwatcher.R
import com.example.tourwatcher.data_layer.objects.Type
import com.example.tourwatcher.helper_layer.Helper.DEFAULT_ITEM_DIFF_UTIL_VALUE

class TypeListAdapter: ListAdapter<Type, TypeListViewHolder>(object: DiffUtil.ItemCallback<Type>() {
    override fun areItemsTheSame(oldItem: Type, newItem: Type) = DEFAULT_ITEM_DIFF_UTIL_VALUE
    override fun areContentsTheSame(oldItem: Type, newItem: Type) = DEFAULT_ITEM_DIFF_UTIL_VALUE
}) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            TypeListViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.type_item_layout, parent, false))

    override fun onBindViewHolder(holder: TypeListViewHolder, position: Int) =
            holder.onBind(getItem(position))
}