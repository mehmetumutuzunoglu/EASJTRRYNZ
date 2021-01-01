package com.mehmetumutuzunoglu.easjtrrynz.feature.tvshow.list

import androidx.databinding.ObservableField
import com.mehmetumutuzunoglu.easjtrrynz.base.components.TvShowItemViewData

class TvShowItem(val itemData: TvShowItemViewData) {
    val itemDataObservable = ObservableField<TvShowItemViewData>()

    init {
        itemDataObservable.set(itemData)
    }
}