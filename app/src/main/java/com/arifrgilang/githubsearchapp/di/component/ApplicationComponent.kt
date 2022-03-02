/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.githubsearchapp.di.component

import com.arifrgilang.data.di.NetworkModule
import com.arifrgilang.data.di.UseCaseModule
import com.arifrgilang.data.searchuser.repository.source.SearchUserEntityData
import com.arifrgilang.data.searchuser.repository.source.SearchUserEntityDataFactory
import com.arifrgilang.githubsearchapp.di.module.ApplicationModule
import dagger.Component
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version AppComponent, v 2.0 2/24/2022 11:29 AM by Arif R Gilang P
 */

@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class, UseCaseModule::class])
interface ApplicationComponent {

    fun inject(dependency: OkHttpClient.Builder)
    fun inject(dependency: Retrofit.Builder)
    fun inject(dependency: Cache)
//    fun inject(dependency: SearchUserEntityDataFactory)
//    fun inject(dependency: SearchUserEntityData)
//    fun inject(dependency: )
}