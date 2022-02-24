/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.domain.searchuser.interactor

import com.arifrgilang.domain.BaseSingleUseCase
import com.arifrgilang.domain.searchuser.model.User
import com.arifrgilang.domain.searchuser.repository.UserRepository

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version GetUsersByUsername, v 2.0 2/24/2022 3:32 PM by Arif R Gilang P
 */
class GetUsersByUsername(
    private val userRepository: UserRepository
) : BaseSingleUseCase<GetUsersByUsername.Params, List<User>>() {

//    override fun invoke(params: Params): List<User> =
//        userRepository.searchUsers(params.username, params.refresh)

    data class Params(val username: String, val refresh: Boolean)
}