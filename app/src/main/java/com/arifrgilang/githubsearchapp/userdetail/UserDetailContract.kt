/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.githubsearchapp.userdetail

import com.arifrgilang.githubsearchapp.base.BasePresenter
import com.arifrgilang.githubsearchapp.base.BaseView
import com.arifrgilang.githubsearchapp.searchuser.model.UserModel

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version UserDetailContract, v 2.0 04/03/22 16.12 by Arif R Gilang P
 */
interface UserDetailContract {

    interface Presenter : BasePresenter {

        fun getUserDetail(username: String, refresh: Boolean)
    }

    interface View : BaseView {

        fun setUserResult(user: UserModel)
    }
}