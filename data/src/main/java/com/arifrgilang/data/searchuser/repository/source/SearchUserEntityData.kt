/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.data.searchuser.repository.source

import com.arifrgilang.data.searchuser.model.UserEntity
import io.reactivex.Observable

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version SearchUserData, v 2.0 25/02/22 11.15 by Arif R Gilang P
 */
interface SearchUserEntityData {

    fun searchUsers(
        username: String
    ): Observable<List<UserEntity>>

    fun getUserProfile(
        username: String
    ): Observable<UserEntity>
}