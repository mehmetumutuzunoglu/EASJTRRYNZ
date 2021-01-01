package com.mehmetumutuzunoglu.easjtrrynz.feature.tvshow

import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.mehmetumutuzunoglu.easjtrrynz.R
import com.mehmetumutuzunoglu.easjtrrynz.base.BaseActivity
import com.mehmetumutuzunoglu.easjtrrynz.databinding.ActivityTvShowsListBinding
import org.koin.android.viewmodel.ext.android.viewModel

class TvShowsActivity : BaseActivity() {

    private val viewModel: TvShowsViewModel by viewModel()
    private lateinit var binding : ActivityTvShowsListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_tv_shows_list)
        binding.viewModel = viewModel
        observeViewModel()
    }

    private fun observeViewModel(){
        viewModel.run {
            getTvShowsList()
        }
    }
}