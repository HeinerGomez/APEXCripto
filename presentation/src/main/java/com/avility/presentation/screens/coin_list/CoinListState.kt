package com.avility.presentation.screens.coin_list

import androidx.annotation.StringRes
import com.avility.domain.model.CoinModel

/**
 * [CoinListState] data class to represent the state of coins
 *
 * @author Heiner Gómez
 * @param [isLoading] to know if the data is fetching
 * @param [data] to represent the coins data
 * @param [errorMessage] to represent any error that can happened
 */
data class CoinListState (
    val isLoading: Boolean = false,
    val data: List<CoinModel> = emptyList(),
    @StringRes val errorMessage: Int? = null
)