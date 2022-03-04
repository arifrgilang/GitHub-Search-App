/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.githubsearchapp.searchuser

import com.arifrgilang.githubsearchapp.base.BasePresenter
import com.arifrgilang.githubsearchapp.base.BaseView
import com.arifrgilang.githubsearchapp.searchuser.model.UserModel

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version SearchUserContract, v 2.0 2/24/2022 12:59 PM by Arif R Gilang P
 */
interface SearchUserContract {

    interface Presenter : BasePresenter {

        fun searchUsers(username: String)
    }

    interface View : BaseView {

        fun setUserResult(users: List<UserModel>)
    }
}