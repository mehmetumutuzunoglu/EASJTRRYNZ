package com.mehmetumutuzunoglu.easjtrrynz.feature.tvshow.list

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mehmetumutuzunoglu.easjtrrynz.feature.tvshow.TvShowsViewModel

class TvShowsScrollListener(
    val viewModel: TvShowsViewModel
) : RecyclerView.OnScrollListener() {


    var currentPage = 1
    var linearLayoutManager: LinearLayoutManager? = null
    var tvShowsScrollHandler: TvShowsScrollHandler? = null
    var pageSize: Int? = null

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        linearLayoutManager?.let {

            val visibleItemCount = it.childCount
            val totalItemCount = it.itemCount
            val firstVisibleItemPosition = it.findFirstVisibleItemPosition()
            if (tvShowsScrollHandler?.isLoading() == false) {
                if (visibleItemCount + firstVisibleItemPosition >= totalItemCount
                    && firstVisibleItemPosition >= 0
                    && totalItemCount >= pageSize ?: Int.MAX_VALUE
                ) {
                    currentPage++
                    viewModel.getTvShowsList(currentPage)
                }
            }
        }
    }

    interface TvShowsScrollHandler {
        fun isLoading(): Boolean
    }
}