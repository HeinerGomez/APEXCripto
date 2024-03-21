package com.avility.domain.repository

import com.avility.domain.model.CoinModel

interface CoinRepository {

    suspend fun getListCoins(): List<CoinModel>

    suspend fun getCoinById(id: String): CoinModel

}