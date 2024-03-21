package com.avility.data.repository

import com.avility.data.mappers.toModel
import com.avility.data.remote.PaprikaAPI
import com.avility.domain.model.CoinModel
import com.avility.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: PaprikaAPI
) : CoinRepository {

    override suspend fun getListCoins(): List<CoinModel> {
        return api.getListCoins().map { it.toModel() }
    }

    override suspend fun getCoinById(id: String): CoinModel {
        return api.getCoinById(id).toModel()
    }
}