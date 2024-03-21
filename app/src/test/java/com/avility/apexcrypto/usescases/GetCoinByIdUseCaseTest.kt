package com.avility.apexcrypto.usescases

import com.avility.apexcrypto.repository.FakeCoinRepository
import com.avility.domain.repository.CoinRepository
import com.avility.domain.usescases.GetCoinByIdUseCase
import com.avility.shared.core.constants.Resource
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetCoinByIdUseCaseTest {
    private lateinit var getCoinByIdUseCase: GetCoinByIdUseCase
    private lateinit var coinFakeCoinRepository: CoinRepository

    @Before
    fun setup() {
        coinFakeCoinRepository = FakeCoinRepository()
        getCoinByIdUseCase = GetCoinByIdUseCase(coinFakeCoinRepository)
    }

    @Test
    fun `When the getCoinByIdUseCase is called with a valid id, it should return a Resource Success object with the found item`() {
        // Give
        val itemId = "btc-bitcoin"

        // When
        val resultResource = runBlocking {
            getCoinByIdUseCase.invoke(itemId)
        }

        // Then
        assert(resultResource is Resource.Success)
        assert(resultResource.data != null)
    }

    @Test
    fun `When the getCoinByIdUseCase is called with an invalid id, it should return a Resource Error object with the corresponding error`() {
        // Give
        val itemId = "INVALID_CODE"

        // When
        val resultResource = runBlocking {
            getCoinByIdUseCase.invoke(itemId)
        }

        // Then
        assert(resultResource is Resource.Error)
        assert(resultResource.message != null)
    }
}