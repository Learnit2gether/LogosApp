package com.example.phonepetest.api.repository

import androidx.lifecycle.LiveData
import com.example.phonepetest.api.model.LogoModel

interface LogoDelegate {
    fun requestLogos(): LiveData<List<LogoModel>>
}