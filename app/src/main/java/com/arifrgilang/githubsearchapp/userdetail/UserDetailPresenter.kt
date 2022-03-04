/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.githubsearchapp.userdetail

import com.arifrgilang.domain.searchuser.interactor.GetUserDetail
import com.arifrgilang.domain.searchuser.model.GetUserDetailRequest
import com.arifrgilang.githubsearchapp.searchuser.mapper.toModel
import javax.inject.Inject

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version UserDetailPresenter, v 2.0 04/03/22 16.13 by Arif R Gilang P
 */
class UserDetailPresenter @Inject constructor(
    private val view: UserDetailContract.View,
    private val getUserDetail: GetUserDetail
) : UserDetailContract.Presenter {

    override fun getUserDetail(username: String, refresh: Boolean) {
        view.showProgress()
        getUserDetail.execute(
            GetUserDetail.Params.createGetUserDetailRequest(
                GetUserDetailRequest(username, refresh)
            ),
            onSuccess = { userResult ->
                view.setUserResult(userResult.toModel())
                view.dismissProgress()
            },
            onError = {
                view.onError(it.message)
                view.dismissProgress()
            }
        )
    }

    override fun resume() {
        // No implementation
    }

    override fun pause() {
        // No implementation
    }

    override fun destroy() {
        getUserDetail.dispose()
    }
}