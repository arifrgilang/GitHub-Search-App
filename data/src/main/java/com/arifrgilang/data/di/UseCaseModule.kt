/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.data.di

import com.arifrgilang.domain.searchuser.interactor.GetUsersByUsername
import com.arifrgilang.domain.searchuser.repository.SearchUserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version UseCaseModule, v 2.0 02/03/22 11.00 by Arif R Gilang P
 */
@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetUsersByUsername(
        searchUserRepository: SearchUserRepository
    ) = GetUsersByUsername(searchUserRepository)
}