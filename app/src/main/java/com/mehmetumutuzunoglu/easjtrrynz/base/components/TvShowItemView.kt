package com.mehmetumutuzunoglu.easjtrrynz.base.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.mehmetumutuzunoglu.easjtrrynz.R
import com.mehmetumutuzunoglu.easjtrrynz.databinding.ViewTvShowItemBinding

@BindingAdapter("item:setData")
fun TvShowItemView.setData(data: TvShowItemViewData?) {
    itemViewModel.handleData(data)
}

class TvShowItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    desStyleAttr: Int = 0
) : FrameLayout(context, attrs, desStyleAttr) {

    private val binding: ViewTvShowItemBinding = DataBindingUtil.inflate(
        LayoutInflater.from(context),
        R.layout.view_tv_show_item,
        this,
        true
    )

    val itemViewModel = TvShowItemViewModel()

    init {
        binding.viewModel = itemViewModel
    }
}