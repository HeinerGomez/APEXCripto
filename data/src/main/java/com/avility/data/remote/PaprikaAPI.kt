package com.avility.data.remote

import com.avility.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface PaprikaAPI {
    @GET("v1/coins")
    suspend fun getListCoins(): List<CoinDto>

    @GET("v1/coins/{coin_id}")
    suspend fun getCoinById(
        @Path("coin_id") coinId: String
    ): CoinDto
}