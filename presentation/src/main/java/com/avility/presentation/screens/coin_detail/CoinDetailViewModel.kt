package com.avility.presentation.screens.coin_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.avility.domain.usescases.GetCoinByIdUseCase
import com.avility.presentation.screens.BaseViewModel
import com.avility.shared.core.constants.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.minutes


/**
 * [CoinDetailViewModel] viewModel to handle the flow of data of the coin
 * @author Heiner Gómez
 * @param [getCoinByIdUseCase] use case to get the results of concrete coin
 */
@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinByIdUseCase: GetCoinByIdUseCase,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<CoinDetailState>(CoinDetailState()) {

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getDetailData(coinId)
        }
    }

    private fun getDetailData(coinId: String) {
        viewModelScope.launch {
            setState(uiState.value.copy(
                isLoading = true
            ))

            val coinResource = getCoinByIdUseCase(coinId)

            setState(uiState.value.copy(
                isLoading = false,
                data = coinResource.data,
                errorMessage = coinResource.message
            ))
        }
    }
}