/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.domain.searchuser.interactor

import com.arifrgilang.domain.base.BaseUseCase
import com.arifrgilang.domain.searchuser.model.GetUserDetailRequest
import com.arifrgilang.domain.searchuser.model.User
import com.arifrgilang.domain.searchuser.repository.SearchUserRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version GetUserDetail, v 2.0 04/03/22 16.41 by Arif R Gilang P
 */
class GetUserDetail @Inject constructor(
    private val searchUserRepository: SearchUserRepository
) : BaseUseCase<GetUserDetail.Params, User>() {

    override fun buildUseCase(params: Params): Observable<User> {
        return searchUserRepository.getUser(
            params.getUserDetailRequest.username,
            params.getUserDetailRequest.refresh
        )
    }

    class Params constructor(internal val getUserDetailRequest: GetUserDetailRequest) {
        companion object {

            fun createGetUserDetailRequest(request: GetUserDetailRequest) = Params(request)
        }
    }
}