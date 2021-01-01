package com.mehmetumutuzunoglu.easjtrrynz.base.components

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class TvShowItemViewModel : ViewModel() {

    var itemImageUrlObservable = ObservableField<String>()
    var itemNameObservable = ObservableField<String>()
    var itemDescriptionObservable = ObservableField<String>()
    var itemRatingObservable = ObservableField<String>()

    fun handleData(data: TvShowItemViewData?) {
        data?.let {
            itemImageUrlObservable.set(it.imageUrl)
            itemNameObservable.set(it.name)
            itemDescriptionObservable.set(it.description)
            itemRatingObservable.set(it.rating + " / 10")
        }
    }
}