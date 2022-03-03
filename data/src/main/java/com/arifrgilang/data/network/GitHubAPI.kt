/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.data.network

import com.arifrgilang.data.searchuser.repository.source.network.response.SearchUserResponse
import com.arifrgilang.data.searchuser.repository.source.network.response.UserResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version GitHubAPI, v 2.0 25/02/22 11.41 by Arif R Gilang P
 */
interface GitHubAPI {

    @GET(Constant.Network.Search.USERS)
    fun searchUsers(
        @Query("q") username: String
    ): Observable<SearchUserResponse>

    @GET(Constant.Network.User.PROFILE)
    fun getUserProfile(
        @Path("param") username: String
    ): Observable<UserResponse>
}