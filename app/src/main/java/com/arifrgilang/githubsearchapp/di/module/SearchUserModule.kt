/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.githubsearchapp.di.module

import android.content.Context
import com.arifrgilang.domain.searchuser.interactor.GetUsersByUsername
import com.arifrgilang.githubsearchapp.di.PerActivity
import com.arifrgilang.githubsearchapp.searchuser.SearchUserActivity
import com.arifrgilang.githubsearchapp.searchuser.SearchUserContract
import com.arifrgilang.githubsearchapp.searchuser.SearchUserPresenter
import com.arifrgilang.githubsearchapp.searchuser.adapter.SearchUserAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version PresentationModule, v 2.0 02/03/22 12.01 by Arif R Gilang P
 */
@Module
class SearchUserModule(
    private val view: SearchUserContract.View
) {

    @PerActivity
    @Provides
    fun provideSearchUsersView(
    ): SearchUserContract.View = view

    @PerActivity
    @Provides
    fun provideSearchUsersPresenter(
        presenter: SearchUserPresenter
    ): SearchUserContract.Presenter = presenter
}