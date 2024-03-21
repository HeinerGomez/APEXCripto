package com.avility.presentation.screens.coin_detail

import androidx.annotation.StringRes
import com.avility.domain.model.CoinModel

/**
 * [CoinDetailState] data class to represent the state of coins
 *
 * @author Heiner Gómez
 * @param [isLoading] to know if the data is fetching
 * @param [data] to represent the coins data of concrete coin
 * @param [errorMessage] to represent any error that can happened
 */
data class CoinDetailState (
    val isLoading: Boolean = false,
    val data: CoinModel? = null,
    val querySearch: String = "",
    @StringRes val errorMessage: Int? = null
)