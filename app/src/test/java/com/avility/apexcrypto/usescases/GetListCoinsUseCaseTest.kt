package com.avility.apexcrypto.usescases

import com.avility.apexcrypto.repository.FakeCoinRepository
import com.avility.domain.repository.CoinRepository
import com.avility.domain.usescases.GetListCoinsUseCase
import com.avility.shared.core.constants.Resource
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetListCoinsUseCaseTest {

    private lateinit var getListCoinsUseCase: GetListCoinsUseCase
    private lateinit var coinFakeCoinRepository: CoinRepository

    @Before
    fun setup() {
        coinFakeCoinRepository = FakeCoinRepository()
        getListCoinsUseCase = GetListCoinsUseCase(coinFakeCoinRepository)
    }

    @Test
    fun `When the getListCoinsUseCase is called, it should return a Resource Success object with a list`() {
        // When
        val resultResource = runBlocking {
            getListCoinsUseCase.invoke()
        }

        // Then
        assert(resultResource is Resource.Success)
    }



}