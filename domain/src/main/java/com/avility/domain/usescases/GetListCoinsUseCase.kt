package com.avility.domain.usescases

import com.avility.domain.model.CoinModel
import com.avility.domain.repository.CoinRepository
import com.avility.shared.R
import com.avility.shared.core.constants.Resource
import timber.log.Timber
import javax.inject.Inject

class GetListCoinsUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    suspend operator fun invoke(): Resource<List<CoinModel>?> {
        var resourceResult: Resource<List<CoinModel>?> = Resource.Error(
            R.string.generic_error
        )

        runCatching {
            coinRepository.getListCoins()
        }.onFailure {
            Timber.e(it)
        }.onSuccess {
            resourceResult = Resource.Success(it)
        }

        return resourceResult
    }
}