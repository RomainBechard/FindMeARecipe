package com.romainbechard.findmearecipe.di

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.romainbechard.findmearecipe.data.source.MyRepository
import com.romainbechard.findmearecipe.data.source.SpoonApi
import com.romainbechard.findmearecipe.data.source.local.LocalDataSource
import com.romainbechard.findmearecipe.data.source.remote.RemoteDataSource
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton

object NetworkModule {

    @Singleton
    @Provides
    fun providesApi(): SpoonApi = Retrofit.Builder()
        .baseUrl("https://api.spoonacular.com/recipes")
        .addConverterFactory(
            JacksonConverterFactory.create(
                ObjectMapper()
                    .registerKotlinModule()
                    .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            )
        )
        .client(
            OkHttpClient().newBuilder()
                .addInterceptor(
                    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
                )
                .build()
        )
        .build()
        .create(SpoonApi::class.java)

    @Singleton
    @Provides
    fun provideTasksRepository(
        @AppModule.DataRemoteSource remoteDataSource: RemoteDataSource,
        @AppModule.DataLocalSource localDataSource: LocalDataSource,
        ioDispatcher: CoroutineDispatcher
    ): MyRepository {
        return MyRepository(
            remoteDataSource, localDataSource, ioDispatcher
        )
    }
}