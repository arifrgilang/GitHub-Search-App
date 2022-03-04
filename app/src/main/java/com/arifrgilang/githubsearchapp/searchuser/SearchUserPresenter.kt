/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.githubsearchapp.searchuser

import com.arifrgilang.domain.searchuser.interactor.SearchUsersByUsername
import com.arifrgilang.domain.searchuser.model.SearchUsersRequest
import com.arifrgilang.githubsearchapp.searchuser.mapper.toModel
import javax.inject.Inject

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version SearchUserPresenter, v 2.0 2/24/2022 12:59 PM by Arif R Gilang P
 */
class SearchUserPresenter @Inject constructor(
    private val view: SearchUserContract.View,
    private val searchUsersByUsername: SearchUsersByUsername
) : SearchUserContract.Presenter {

    override fun searchUsers(username: String) {
        view.showProgress()
        searchUsersByUsername.execute(
            SearchUsersByUsername.Params.createSearchUserRequest(
                SearchUsersRequest(username, true)
            ),
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
        searchUsersByUsername.dispose()
    }
}