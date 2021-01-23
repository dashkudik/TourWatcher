package com.example.tourwatcher.presentation_layer.filter_fragment.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.tourwatcher.data_layer.objects.Type
import kotlinx.android.synthetic.main.type_item_layout.view.*

class TypeListViewHolder(view: View): RecyclerView.ViewHolder(view) {
    fun onBind(type: Type) {
        with(itemView) {
            tv_type.text = type.name
            checkbox_type.isChecked = type.isChecked
        }
    }
}