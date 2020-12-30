package com.mehmetumutuzunoglu.easjtrrynz.base.di

import retrofit2.http.GET

interface ApiService {

    @GET("/tv/popular")
    fun getPopularTvList()
}