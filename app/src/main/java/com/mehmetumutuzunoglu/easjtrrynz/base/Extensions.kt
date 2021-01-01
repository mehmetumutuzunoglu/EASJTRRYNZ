package com.mehmetumutuzunoglu.easjtrrynz.base

import android.view.View
import android.webkit.URLUtil
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("app:loadImage")
fun ImageView.load(url: String?) {
    url?.let {
        val imageUrl = BaseApplication.IMAGE_URL + it
        visibility = if (URLUtil.isValidUrl(imageUrl)) {
            Glide.with(context).load(imageUrl).into(this)
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}

