package com.mehmetumutuzunoglu.easjtrrynz.feature.tvshow

import com.mehmetumutuzunoglu.easjtrrynz.base.ApiClient

class TvShowsRepository {
    fun getTvShows() = ApiClient.getRetrofitClient()?.getPopularTvList()
}