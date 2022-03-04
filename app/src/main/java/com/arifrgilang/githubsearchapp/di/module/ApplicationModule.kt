/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.githubsearchapp.di.module

import android.app.Application
import android.content.Context
import com.arifrgilang.data.network.GitHubAPI
import com.arifrgilang.data.searchuser.repository.SearchUserEntityRepository
import com.arifrgilang.data.searchuser.repository.source.SearchUserEntityDataFactory
import com.arifrgilang.data.searchuser.repository.source.mock.MockSearchUserEntityData
import com.arifrgilang.data.searchuser.repository.source.network.NetworkSearchUserEntityData
import com.arifrgilang.domain.searchuser.repository.SearchUserRepository
import com.arifrgilang.githubsearchapp.di.PerActivity
import com.arifrgilang.githubsearchapp.searchuser.SearchUserActivity
import com.arifrgilang.githubsearchapp.searchuser.SearchUserContract
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version AppModule, v 2.0 2/24/2022 11:30 AM by Arif R Gilang P
 */

@Module
class ApplicationModule(private val app: Application) {

    @Singleton
    @Provides
    fun provideContext(): Context = app

    @Singleton
    @Provides
    fun provideApplication(): Application = app

    @Singleton
    @Provides
    fun provideSearchUserRepository(
        searchUserEntityRepository: SearchUserEntityRepository
    ): SearchUserRepository =
        searchUserEntityRepository
}