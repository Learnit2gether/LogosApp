package com.example.phonepetest.di

import com.example.phonepetest.api.GameRepository
import com.example.phonepetest.api.datasource.GameDataSource
import com.example.phonepetest.api.datasource.GameDataSourceImpl
import com.example.phonepetest.api.repository.LogoDelegate
import com.example.phonepetest.api.repository.LogoDelegateImpl
import com.example.phonepetest.usecase.GameWindowUseCase
import com.example.phonepetest.vm.GameWindowViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel(override = true) {
        GameWindowViewModel(useCase = get())
    }
}

val useCaseModule = module {
    single { GameWindowUseCase(repo = get()) }
}

val repositoryModule = module {
    single { GameRepository(logoDelegate = get()) }
    single<LogoDelegate> { LogoDelegateImpl(mockDataSource = get()) }
}

val networkDataSourceModule = module {
    single<GameDataSource> { GameDataSourceImpl() }
}

