/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.data.searchuser.repository.source.network

import com.arifrgilang.data.network.GitHubAPI
import com.arifrgilang.data.searchuser.mapper.toEntity
import com.arifrgilang.data.searchuser.model.UserEntity
import com.arifrgilang.data.searchuser.repository.source.SearchUserEntityData
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version NetworkSearchUserEntityData, v 2.0 25/02/22 11.16 by Arif R Gilang P
 */
class NetworkSearchUserEntityData @Inject constructor(
    private val gitHubAPI: GitHubAPI
) : SearchUserEntityData {

    override fun searchUsers(username: String): Observable<List<UserEntity>> {
        return gitHubAPI.searchUsers(username).map { response ->
            response.items?.map { user ->
                user.toEntity()
            }
        }
    }

    override fun getUserProfile(username: String): Observable<UserEntity> {
        return gitHubAPI.getUserProfile(username).map { it.toEntity() }
    }

}