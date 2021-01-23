package com.example.tourwatcher.data_layer.network

import com.example.tourwatcher.data_layer.objects.Filter
import retrofit2.http.GET


interface NetworkService {
    @GET("path")
    fun getTournaments(filter: Filter)
}