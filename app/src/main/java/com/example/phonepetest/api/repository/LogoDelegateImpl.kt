package com.example.phonepetest.api.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.phonepetest.api.datasource.GameDataSource
import com.example.phonepetest.api.model.LogoModel

class LogoDelegateImpl(val mockDataSource: GameDataSource): LogoDelegate {

    override fun requestLogos(): LiveData<List<LogoModel>> = liveData {
        emit(mockDataSource.requestLogos())
    }
}