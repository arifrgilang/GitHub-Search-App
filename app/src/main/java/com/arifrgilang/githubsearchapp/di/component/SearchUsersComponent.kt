/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.githubsearchapp.di.component

import com.arifrgilang.githubsearchapp.di.PerActivity
import com.arifrgilang.githubsearchapp.di.module.SearchUserModule
import com.arifrgilang.githubsearchapp.searchuser.SearchUserActivity
import dagger.Component

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version SearchUsersComponent, v 2.0 04/03/22 05.47 by Arif R Gilang P
 */
@PerActivity
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [SearchUserModule::class]
)
interface SearchUsersComponent {

    fun inject(activity: SearchUserActivity)
}