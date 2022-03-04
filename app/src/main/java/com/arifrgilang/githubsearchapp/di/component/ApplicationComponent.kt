/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.githubsearchapp.di.component

import android.content.Context
import com.arifrgilang.data.di.DatabaseModule
import com.arifrgilang.data.di.NetworkModule
import com.arifrgilang.domain.searchuser.repository.SearchUserRepository
import com.arifrgilang.githubsearchapp.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version AppComponent, v 2.0 2/24/2022 11:29 AM by Arif R Gilang P
 */

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        NetworkModule::class,
        DatabaseModule::class
    ]
)
interface ApplicationComponent {

    fun context(): Context
    fun searchUserRepository(): SearchUserRepository
}