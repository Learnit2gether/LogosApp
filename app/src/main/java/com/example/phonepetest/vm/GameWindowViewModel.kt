package com.example.phonepetest.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.phonepetest.api.model.LogoModel
import com.example.phonepetest.usecase.GameWindowUseCase

class GameWindowViewModel(val useCase: GameWindowUseCase): ViewModel() {
    private val _triggerLogoRequest = MutableLiveData<Boolean>()

    val logoListModel: LiveData<List<LogoModel>> = Transformations.switchMap(_triggerLogoRequest){
        useCase.requestLogos()
    }

    fun requestLogos(){
        _triggerLogoRequest.value = true
    }


}