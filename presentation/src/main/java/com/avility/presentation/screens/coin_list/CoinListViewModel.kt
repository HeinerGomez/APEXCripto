package com.avility.presentation.screens.coin_list

import androidx.lifecycle.viewModelScope
import com.avility.domain.usescases.GetListCoinsUseCase
import com.avility.presentation.screens.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * [CoinListViewModel] viewModel to handle the flow of data of coins
 *
 * @author Heiner Gómez
 * @param [getListCoinsUseCase] use case to get the results of list coins
 */
@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getListCoinsUseCase: GetListCoinsUseCase,
) : BaseViewModel<CoinListState>(CoinListState()) {

    init {
        viewModelScope.launch {
            setState(uiState.value.copy(
                isLoading = true
            ))

            val coinListResource = getListCoinsUseCase()

            setState(uiState.value.copy(
                isLoading = false,
                data = coinListResource.data.orEmpty(),
                errorMessage = coinListResource.message
            ))
        }
    }
}