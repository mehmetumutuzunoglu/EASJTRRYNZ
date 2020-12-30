package com.mehmetumutuzunoglu.easjtrrynz.base.di

import com.mehmetumutuzunoglu.easjtrrynz.feature.tvshowlist.TvShowsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        TvShowsViewModel()
    }
}

val repositoryModule = module {

}