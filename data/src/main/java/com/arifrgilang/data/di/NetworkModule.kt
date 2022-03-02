/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.data.di

import android.content.Context
import com.arifrgilang.data.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version NetworkModule, v 2.0 2/24/2022 11:45 AM by Arif R Gilang P
 */

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideBaseURL() = BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(
    ): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        }
    }

    @Provides
    @Singleton
    fun provideCache(context: Context): Cache =
        Cache(context.cacheDir, cacheSize.toLong())

    @Provides
    @Singleton
    fun provideOkHttpClientBuilder(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        cache: Cache
    ): OkHttpClient.Builder =
        OkHttpClient.Builder()
            .writeTimeout(DEFAULT_TIME_OUT, TimeUnit.MILLISECONDS)
            .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.MILLISECONDS)
            .readTimeout(DEFAULT_TIME_OUT, TimeUnit.MILLISECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .cache(cache)

    @Provides
    @Singleton
    fun provideRetrofitBuilder(
        baseUrl: String
    ): Retrofit.Builder =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())

    private val DATE_FORMAT = "yyyy-MM-dd'T'hh:mm:ssZ"
    private val DEFAULT_TIME_OUT: Long = 30L * 1000
    private val cacheSize = 10 * 1024 * 1024
}