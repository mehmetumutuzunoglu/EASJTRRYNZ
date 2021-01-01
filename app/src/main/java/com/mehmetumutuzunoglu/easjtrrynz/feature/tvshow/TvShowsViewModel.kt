package com.mehmetumutuzunoglu.easjtrrynz.feature.tvshow

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mehmetumutuzunoglu.easjtrrynz.base.components.TvShowItemViewData
import com.mehmetumutuzunoglu.easjtrrynz.base.model.PopularTvListResponse
import com.mehmetumutuzunoglu.easjtrrynz.feature.tvshow.list.TvShowItem
import com.mehmetumutuzunoglu.easjtrrynz.feature.tvshow.list.TvShowsScrollListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TvShowsViewModel(private val tvShowsRepository: TvShowsRepository) : ViewModel(),
    TvShowsScrollListener.TvShowsScrollHandler {

    val setAdapterLiveData = MutableLiveData<List<TvShowItem>>()

    var loading = false

    fun getTvShowsList(page: Int = 1) {
        loading = true
        val call: Call<PopularTvListResponse>? = tvShowsRepository.getTvShows(page)
        call?.enqueue(object : Callback<PopularTvListResponse> {
            override fun onResponse(
                call: Call<PopularTvListResponse>,
                response: Response<PopularTvListResponse>
            ) {
                response.body()?.let {
                    setAdapterLiveData.value = it.results?.map { item ->
                        TvShowItem(
                            TvShowItemViewData(
                                imageUrl = item.posterPath,
                                name = item.name,
                                description = item.overview,
                                rating = item.voteAverage.toString()
                            )
                        )
                    }
                }
                loading = false
            }

            override fun onFailure(call: Call<PopularTvListResponse>, t: Throwable) {
                Log.e("FAIL", "HATA")
                loading = false
            }
        })
    }

    override fun isLoading() = loading


}