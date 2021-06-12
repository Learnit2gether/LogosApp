package com.example.phonepetest

import android.app.Application
import com.example.phonepetest.di.networkDataSourceModule
import com.example.phonepetest.di.repositoryModule
import com.example.phonepetest.di.useCaseModule
import com.example.phonepetest.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class LogosApp : Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@LogosApp)
            modules(
                listOf(
                    viewModelModule,
                    useCaseModule,
                    repositoryModule,
                    networkDataSourceModule
                )
            )
        }
    }

}