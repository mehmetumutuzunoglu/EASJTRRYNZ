package com.mehmetumutuzunoglu.easjtrrynz.feature.tvshow.detail

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.mehmetumutuzunoglu.easjtrrynz.R
import com.mehmetumutuzunoglu.easjtrrynz.base.BaseActivity
import com.mehmetumutuzunoglu.easjtrrynz.databinding.ActivityTvShowDetailBinding
import org.koin.android.viewmodel.ext.android.viewModel

class TvShowDetailActivity : BaseActivity() {

    private val viewModel: TvShowDetailViewModel by viewModel()
    private lateinit var binding: ActivityTvShowDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show_detail)
        binding.viewModel = viewModel


        viewModel.parseIntent(intent)
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.run {
            getDetail()

            errorDialogLiveData.observe(this@TvShowDetailActivity, {
                showErrorDialog()
            })
        }
    }
}