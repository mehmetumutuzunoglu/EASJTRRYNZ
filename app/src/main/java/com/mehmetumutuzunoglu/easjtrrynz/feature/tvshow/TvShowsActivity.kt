package com.mehmetumutuzunoglu.easjtrrynz.feature.tvshow

import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mehmetumutuzunoglu.easjtrrynz.R
import com.mehmetumutuzunoglu.easjtrrynz.base.BaseActivity
import com.mehmetumutuzunoglu.easjtrrynz.databinding.ActivityTvShowsListBinding
import com.mehmetumutuzunoglu.easjtrrynz.feature.tvshow.list.TvShowsAdapter
import com.mehmetumutuzunoglu.easjtrrynz.feature.tvshow.list.TvShowsScrollListener
import org.koin.android.viewmodel.ext.android.viewModel

class TvShowsActivity : BaseActivity() {

    private val viewModel: TvShowsViewModel by viewModel()
    private lateinit var binding: ActivityTvShowsListBinding

    private var tvShowsScrollListener: TvShowsScrollListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_shows_list)
        binding.viewModel = viewModel
        setUI()
        observeViewModel()
    }

    private fun setUI() {
        binding.tvShowsList.run {
            adapter = TvShowsAdapter()
            tvShowsScrollListener = TvShowsScrollListener(viewModel).apply {
                linearLayoutManager =  binding.tvShowsList.layoutManager as? LinearLayoutManager
                tvShowsScrollHandler = viewModel
            }

        }
    }

    private fun observeViewModel() {
        viewModel.run {
            getTvShowsList()

            setAdapterLiveData.observe(this@TvShowsActivity, Observer {list ->
                (binding.tvShowsList.adapter as? TvShowsAdapter)?.addList(list)
                tvShowsScrollListener?.let {
                    it.pageSize = list.size
                    binding.tvShowsList.addOnScrollListener(it)
                }
            })
        }
    }
}