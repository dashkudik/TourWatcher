package com.example.tourwatcher.presentation_layer.filter_fragment

import android.app.Application
import android.app.Instrumentation
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_BACK
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.lifecycle.ViewModelProvider
import com.example.tourwatcher.App
import com.example.tourwatcher.App.Companion.appComponent
import com.example.tourwatcher.App.Companion.dataComponent
import com.example.tourwatcher.R
import com.example.tourwatcher.data_layer.repositories.FilterPreferencesRepository
import com.example.tourwatcher.helper_layer.Helper.executeOnBackgroundThread
import com.example.tourwatcher.helper_layer.Helper.withAll
import com.example.tourwatcher.presentation_layer.filter_fragment.adapters.TypeListAdapter
import kotlinx.android.synthetic.main.fragment_filter.*
import javax.inject.Inject


class FilterFragment : Fragment() {
    private val recyclerTypeAdapter = TypeListAdapter()
    private lateinit var viewModel: FilterFragmentViewModel

    @Inject lateinit var application: Application
    @Inject lateinit var applicationContext: Context

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_filter, container, false)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        appComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider
            .AndroidViewModelFactory
            .getInstance(application)
            .create(FilterFragmentViewModel::class.java)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_type.adapter = recyclerTypeAdapter

        viewModel.getTypes()
        viewModel.typeLiveData.observe(viewLifecycleOwner) { types ->
            if (types != null) {
                recyclerTypeAdapter.submitList(types)
            } else {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.unknown_error_message),
                    LENGTH_SHORT
                ).show()
            }
        }

        btn_back.setOnClickListener {
            executeOnBackgroundThread {
                Instrumentation().sendKeyDownUpSync(KEYCODE_BACK)
            }
        }
    }
}