package com.example.tourwatcher.presentation_layer.tourlist_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.tourwatcher.R
import javax.inject.Inject

class TourListFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_tour_list, container, false)

}