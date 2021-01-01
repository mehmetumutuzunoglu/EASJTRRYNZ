package com.mehmetumutuzunoglu.easjtrrynz.base

import android.app.Application
import com.mehmetumutuzunoglu.easjtrrynz.base.di.repositoryModule
import com.mehmetumutuzunoglu.easjtrrynz.base.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(listOf(viewModelModule, repositoryModule))
        }
    }
}