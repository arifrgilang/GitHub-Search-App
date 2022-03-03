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
import com.arifrgilang.githubsearchapp.di.PerActivity
import com.arifrgilang.githubsearchapp.di.module.ApplicationModule
import com.arifrgilang.githubsearchapp.di.module.SearchUserModule
import com.arifrgilang.githubsearchapp.searchuser.SearchUserActivity
import com.arifrgilang.githubsearchapp.searchuser.SearchUserPresenter
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
        SearchUserModule::class,
        UseCaseModule::class
    ]
)
interface ApplicationComponent {

    fun inject(activity: SearchUserActivity)
    fun inject(presenter: SearchUserPresenter)
}