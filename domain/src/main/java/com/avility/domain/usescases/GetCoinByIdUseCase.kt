package com.avility.domain.usescases

import com.avility.domain.model.CoinModel
import com.avility.domain.repository.CoinRepository
import com.avility.shared.R
import com.avility.shared.core.constants.Resource
import timber.log.Timber
import javax.inject.Inject

class GetCoinByIdUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    suspend operator fun invoke(id: String): Resource<CoinModel?> {
        var resourceResponse: Resource<CoinModel?> = Resource.Error(
            R.string.generic_error
        )

        runCatching {
            coinRepository.getCoinById(id)
        }.onFailure {
            Timber.e(it)
        }.onSuccess {
            resourceResponse = Resource.Success(it)
        }

        return resourceResponse
    }
}