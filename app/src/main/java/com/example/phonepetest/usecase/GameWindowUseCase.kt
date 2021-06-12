package com.example.phonepetest.usecase

import androidx.lifecycle.LiveData
import com.example.phonepetest.api.GameRepository
import com.example.phonepetest.api.model.LogoModel

class GameWindowUseCase(val repo: GameRepository) {
    fun requestLogos(): LiveData<List<LogoModel>> {
        return repo.requestLogos()
    }
}