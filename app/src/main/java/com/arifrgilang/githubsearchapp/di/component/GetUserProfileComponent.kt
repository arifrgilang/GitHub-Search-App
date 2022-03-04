/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.githubsearchapp.di.component

import com.arifrgilang.githubsearchapp.di.PerActivity
import com.arifrgilang.githubsearchapp.di.module.GetUserProfileModule
import com.arifrgilang.githubsearchapp.userdetail.UserDetailActivity
import dagger.Component

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version GetUserProfileComponent, v 2.0 04/03/22 16.51 by Arif R Gilang P
 */

@PerActivity
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [GetUserProfileModule::class]
)
interface GetUserProfileComponent {

    fun inject(activity: UserDetailActivity)
}