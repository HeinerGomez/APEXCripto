package com.avility.apexcrypto.repository

import com.avility.data.mappers.toModel
import com.avility.data.remote.dto.CoinDto
import com.avility.domain.model.CoinModel
import com.avility.domain.repository.CoinRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import timber.log.Timber

class FakeCoinRepository : CoinRepository {

    private val moshi = Moshi.Builder()
        .build()

    private inline fun <reified T> Moshi.parseList(jsonString: String): List<T>? {
        return adapter<List<T>>(Types.newParameterizedType(List::class.java, T::class.java)).fromJson(jsonString)
    }

    override suspend fun getListCoins(): List<CoinModel> {
        try {
            val data: List<CoinDto> = moshi.parseList(this::class.java.classLoader
                ?.getResource("coin_data.json")?.readText().orEmpty()) ?: emptyList()

            return data.map { it.toModel() }
        } catch (e: Exception) {
            Timber.e(e)
        }

        return emptyList()
    }

    override suspend fun getCoinById(id: String): CoinModel {
        val adapter = moshi.adapter(CoinDto::class.java)
        val data = adapter.fromJson(
            this::class.java.classLoader?.getResource("detail_coin_data.json")?.readText().orEmpty()
        )?.toModel()

        var itemFound = if (data?.id == id) {
            data
        } else {
            null
        }

        return itemFound!!
    }
}