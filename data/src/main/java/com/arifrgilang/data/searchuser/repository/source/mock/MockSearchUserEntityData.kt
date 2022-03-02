/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.data.searchuser.repository.source.mock

import com.arifrgilang.data.searchuser.model.UserEntity
import com.arifrgilang.data.searchuser.repository.source.SearchUserEntityData
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version MockSearchUserEntityData, v 2.0 25/02/22 11.16 by Arif R Gilang P
 */
class MockSearchUserEntityData @Inject constructor() : SearchUserEntityData {

    override fun searchUsers(username: String): Observable<List<UserEntity>> {
        TODO("Not yet implemented")
    }

    override fun getUserProfile(username: String): Observable<UserEntity> {
        TODO("Not yet implemented")
    }

}