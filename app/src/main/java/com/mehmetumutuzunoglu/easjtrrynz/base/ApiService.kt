package com.mehmetumutuzunoglu.easjtrrynz.base

import com.mehmetumutuzunoglu.easjtrrynz.base.model.PopularTvListResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("tv/popular")
    fun getPopularTvList(): Call<PopularTvListResponse>
}