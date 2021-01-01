package com.mehmetumutuzunoglu.easjtrrynz.feature.tvshow

import android.util.Log
import androidx.lifecycle.ViewModel
import com.mehmetumutuzunoglu.easjtrrynz.base.model.PopularTvListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TvShowsViewModel(private val tvShowsRepository: TvShowsRepository) : ViewModel() {


    fun getTvShowsList() {
        val call: Call<PopularTvListResponse>? = tvShowsRepository.getTvShows()
        call?.enqueue(object : Callback<PopularTvListResponse> {
            override fun onResponse(
                call: Call<PopularTvListResponse>,
                response: Response<PopularTvListResponse>
            ) {
                response.body()?.let {
                    Log.e("Succes", it.toString())
                }
            }

            override fun onFailure(call: Call<PopularTvListResponse>, t: Throwable) {
                Log.e("FAIL", "HATA")
            }
        })
    }
}