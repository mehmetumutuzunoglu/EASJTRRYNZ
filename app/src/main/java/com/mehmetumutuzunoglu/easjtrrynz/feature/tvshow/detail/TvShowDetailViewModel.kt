package com.mehmetumutuzunoglu.easjtrrynz.feature.tvshow.detail

import android.content.Intent
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mehmetumutuzunoglu.easjtrrynz.base.BaseActivity
import com.mehmetumutuzunoglu.easjtrrynz.base.model.TvShowDetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TvShowDetailViewModel(private val tvShowDetailRepository: TvShowDetailRepository) :
    ViewModel() {

    private var itemId: Int? = null

    var imageUrlObservable = ObservableField<String>()
    var nameObservable = ObservableField<String>()
    var descriptionObservable = ObservableField<String>()
    var ratingObservable = ObservableField<String>()

    private val errorDialogMutableLiveData = MutableLiveData<Unit>()
    val errorDialogLiveData: LiveData<Unit> get() = errorDialogMutableLiveData

    fun getDetail() {
        val call: Call<TvShowDetailResponse>? = tvShowDetailRepository.getTvShowDetail(itemId)
        call?.enqueue(object : Callback<TvShowDetailResponse> {
            override fun onResponse(
                call: Call<TvShowDetailResponse>,
                response: Response<TvShowDetailResponse>
            ) {
                response.body()?.let {
                    handleData(it)
                }
            }

            override fun onFailure(call: Call<TvShowDetailResponse>, t: Throwable) {
                errorDialogMutableLiveData.value = Unit
            }

        })
    }

    private fun handleData(result: TvShowDetailResponse?) {
        result?.let {
            imageUrlObservable.set(it.backdropImageUrl)
            nameObservable.set(it.name)
            descriptionObservable.set(it.overview)
            ratingObservable.set(it.voteAverage.toString() + " / 10")
        }
    }

    fun parseIntent(intent: Intent) {
        itemId = intent.getIntExtra(BaseActivity.ITEM_ID, 0)
    }
}