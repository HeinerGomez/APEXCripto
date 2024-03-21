package com.avility.apexcrypto.di

import com.avility.data.remote.PaprikaAPI
import com.avility.data.repository.CoinRepositoryImpl
import com.avility.domain.repository.CoinRepository
import com.avility.shared.core.constants.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            ).build()
    }

    @Provides
    @Singleton
    fun providePaprikaAPI(client: OkHttpClient): PaprikaAPI {
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL_API_PAPRIKA)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: PaprikaAPI): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}