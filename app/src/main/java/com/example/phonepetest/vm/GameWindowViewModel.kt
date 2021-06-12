package com.example.phonepetest.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.phonepetest.api.model.LogoModel
import com.example.phonepetest.usecase.GameWindowUseCase
import com.example.phonepetest.util.Event

class GameWindowViewModel(val useCase: GameWindowUseCase): ViewModel() {
    private val _triggerLogoRequest = MutableLiveData<Boolean>()
    private val logoListModelLd: LiveData<List<LogoModel>> = Transformations.switchMap(_triggerLogoRequest){
        useCase.requestLogos()
    }

    val logoListModelEventLd: LiveData<Event<List<LogoModel>>> = Transformations.map(logoListModelLd){
        Event(it)
    }

    fun requestLogos(){
        _triggerLogoRequest.value = true
    }

    private val selectedLogoModel = MutableLiveData<LogoModel>()
    val imageModelLd = Transformations.map(selectedLogoModel){
        it.imgUrl
    }

    // call this method on next button
    fun getNextLogo(position: Int) {
        selectedLogoModel.value = logoListModelEventLd.value?.peekContent()?.get(position)
    }


}