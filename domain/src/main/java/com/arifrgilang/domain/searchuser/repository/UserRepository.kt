/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.domain.searchuser.repository

import com.arifrgilang.domain.searchuser.model.User
import io.reactivex.Single

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version UserRepository, v 2.0 2/24/2022 3:29 PM by Arif R Gilang P
 */
interface UserRepository {

    fun searchUsers(
        username: String,
        refresh: Boolean
    ): Single<List<User>>

    fun getUser(
        username: String,
        refresh: Boolean
    ): Single<User>
}