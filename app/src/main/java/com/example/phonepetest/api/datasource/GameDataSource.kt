package com.example.phonepetest.api.datasource

import com.example.phonepetest.api.model.LogoModel

interface GameDataSource {
    suspend fun requestLogos(): List<LogoModel>
}