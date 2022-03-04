/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.domain.searchuser.interactor

import com.arifrgilang.domain.base.BaseUseCase
import com.arifrgilang.domain.searchuser.model.SearchUsersRequest
import com.arifrgilang.domain.searchuser.model.User
import com.arifrgilang.domain.searchuser.repository.SearchUserRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version GetUsersByUsername, v 2.0 2/24/2022 3:32 PM by Arif R Gilang P
 */
class SearchUsersByUsername @Inject constructor(
    private val searchUserRepository: SearchUserRepository
) : BaseUseCase<SearchUsersByUsername.Params, List<User>>() {

    override fun buildUseCase(params: Params): Observable<List<User>> {
        return searchUserRepository.searchUsers(
            params.searchUsersRequest.username,
            params.searchUsersRequest.refresh
        )
    }

    class Params constructor(internal val searchUsersRequest: SearchUsersRequest) {
        companion object {

            fun createSearchUserRequest(request: SearchUsersRequest) = Params(request)
        }
    }
}