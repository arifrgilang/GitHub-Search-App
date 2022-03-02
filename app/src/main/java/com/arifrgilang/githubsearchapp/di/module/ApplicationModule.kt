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
import com.arifrgilang.data.searchuser.repository.source.local.PersistenceSearchUserEntityData
import com.arifrgilang.data.searchuser.repository.source.local.dao.UserEntityDao
import com.arifrgilang.data.searchuser.repository.source.mock.MockSearchUserEntityData
import com.arifrgilang.data.searchuser.repository.source.network.NetworkSearchUserEntityData
import com.arifrgilang.data.util.DataStoreHelper
import com.arifrgilang.domain.searchuser.repository.SearchUserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version AppModule, v 2.0 2/24/2022 11:30 AM by Arif R Gilang P
 */

@Module
class ApplicationModule(private val app: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideUserEntityDataFactory(
        localRepository: PersistenceSearchUserEntityData,
        mockRepository: MockSearchUserEntityData,
        remoteRepository: NetworkSearchUserEntityData
    ) = SearchUserEntityDataFactory(localRepository, mockRepository, remoteRepository)

    @Provides
    @Singleton
    fun provideLocalRepository(
        userEntityDao: UserEntityDao,
        dataStoreHelper: DataStoreHelper
    ) = PersistenceSearchUserEntityData(userEntityDao, dataStoreHelper)

    @Provides
    @Singleton
    fun provideMockRepository() = MockSearchUserEntityData()

    @Provides
    @Singleton
    fun provideRemoteRepository(
        gitHubApi: GitHubAPI
    ) = NetworkSearchUserEntityData(gitHubApi)

    @Provides
    @Singleton
    fun provideSearchUserRepository(
        searchUserRepositoryFactory: SearchUserEntityDataFactory
    ): SearchUserRepository =
        SearchUserEntityRepository(searchUserRepositoryFactory)
}