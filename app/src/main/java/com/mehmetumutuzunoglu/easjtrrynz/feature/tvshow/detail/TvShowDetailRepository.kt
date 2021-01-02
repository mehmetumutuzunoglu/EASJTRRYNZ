package com.mehmetumutuzunoglu.easjtrrynz.feature.tvshow.detail

import com.mehmetumutuzunoglu.easjtrrynz.base.ApiClient

class TvShowDetailRepository {

    fun getTvShowDetail(itemId: Int?) = ApiClient.getRetrofitClient()?.getDetail(itemId)
}