/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.githubsearchapp.searchuser

import com.arifrgilang.domain.searchuser.interactor.GetUsersByUsername
import com.arifrgilang.githubsearchapp.searchuser.mapper.toModel
import javax.inject.Inject

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version SearchUserPresenter, v 2.0 2/24/2022 12:59 PM by Arif R Gilang P
 */
class SearchUserPresenter @Inject constructor(
    private val getUsersByUsername: GetUsersByUsername
) : SearchUserContract.Presenter {

    lateinit var view: SearchUserContract.View

    override fun setViewPresenter(viewPresenter: SearchUserContract.View) {
        view = viewPresenter
    }

    override fun searchUsers(username: String) {
        view.showProgress()
        getUsersByUsername.execute(
            GetUsersByUsername.Params(username, true),
            onSuccess = { usersResult ->
                view.setUserResult(usersResult.map { it.toModel() })
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
        getUsersByUsername.dispose()
    }
}