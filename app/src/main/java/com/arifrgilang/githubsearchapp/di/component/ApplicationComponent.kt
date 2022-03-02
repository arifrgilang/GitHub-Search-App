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
import com.arifrgilang.data.searchuser.repository.source.local.PersistenceSearchUserEntityData
import com.arifrgilang.domain.searchuser.interactor.GetUsersByUsername
import com.arifrgilang.githubsearchapp.di.module.ApplicationModule
import com.arifrgilang.githubsearchapp.di.module.PresentationModule
import com.arifrgilang.githubsearchapp.searchuser.SearchUserActivity
import com.arifrgilang.githubsearchapp.searchuser.SearchUserPresenter
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
@Component(modules = [
    ApplicationModule::class,
    NetworkModule::class,
    UseCaseModule::class,
    PresentationModule::class]
)
interface ApplicationComponent {

//    fun inject(dependency: OkHttpClient.Builder)
//    fun inject(dependency: Retrofit.Builder)
//    fun inject(dependency: Cache)
//    fun inject(dependency: PersistenceSearchUserEntityData)
    fun inject(activity: SearchUserActivity)
    fun inject(presenter: SearchUserPresenter)
//    fun inject(useCase: GetUsersByUsername)
//    fun inject(dependency: SearchUserEntityDataFactory)
//    fun inject(dependency: SearchUserEntityData)
//    fun inject(dependency: )
}