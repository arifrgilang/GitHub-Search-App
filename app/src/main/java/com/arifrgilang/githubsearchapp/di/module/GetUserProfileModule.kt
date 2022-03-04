/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.githubsearchapp.di.module

import com.arifrgilang.githubsearchapp.di.PerActivity
import com.arifrgilang.githubsearchapp.userdetail.UserDetailContract
import com.arifrgilang.githubsearchapp.userdetail.UserDetailPresenter
import dagger.Module
import dagger.Provides

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version GetUserProfileModule, v 2.0 04/03/22 16.51 by Arif R Gilang P
 */
@Module
class GetUserProfileModule(
    private val view: UserDetailContract.View
) {

    @PerActivity
    @Provides
    fun provideUserDetailView(
    ): UserDetailContract.View = view

    @PerActivity
    @Provides
    fun provideUserDetailPresenter(
        presenter: UserDetailPresenter
    ): UserDetailContract.Presenter = presenter
}