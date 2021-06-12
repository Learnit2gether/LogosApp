package com.example.phonepetest.api.datasource

import com.example.phonepetest.api.mock.mockLogoJson
import com.example.phonepetest.api.model.LogoModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GameDataSourceImpl : GameDataSource {

    override suspend fun requestLogos(): List<LogoModel> {
        val factory = Gson()
        val type = object : TypeToken<List<LogoModel>>() {}.type
        val model: List<LogoModel> = factory.fromJson(mockLogoJson, type)
        return model
    }

}