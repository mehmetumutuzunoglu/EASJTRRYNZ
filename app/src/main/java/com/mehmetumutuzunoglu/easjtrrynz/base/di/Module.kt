package com.mehmetumutuzunoglu.easjtrrynz.base.di

import com.mehmetumutuzunoglu.easjtrrynz.feature.tvshow.TvShowsRepository
import com.mehmetumutuzunoglu.easjtrrynz.feature.tvshow.TvShowsViewModel
import com.mehmetumutuzunoglu.easjtrrynz.feature.detail.TvShowDetailRepository
import com.mehmetumutuzunoglu.easjtrrynz.feature.detail.TvShowDetailViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        TvShowsViewModel(get())
    }
    viewModel {
        TvShowDetailViewModel(get())
    }
}

val repositoryModule = module {
    single {
        TvShowsRepository()
    }
    single {
        TvShowDetailRepository()
    }
}