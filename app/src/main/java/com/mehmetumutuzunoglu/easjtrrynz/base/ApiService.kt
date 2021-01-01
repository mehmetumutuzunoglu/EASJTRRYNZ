package com.mehmetumutuzunoglu.easjtrrynz.base

import com.mehmetumutuzunoglu.easjtrrynz.base.model.PopularTvListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("tv/popular")
    fun getPopularTvList(
        @Query("page")
        page: Int?
    ): Call<PopularTvListResponse>
}