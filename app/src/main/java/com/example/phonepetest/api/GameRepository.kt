package com.example.phonepetest.api

import com.example.phonepetest.api.repository.LogoDelegate


class GameRepository(
    private val logoDelegate: LogoDelegate
) : LogoDelegate by logoDelegate {

}