/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.data.searchuser.repository

import com.arifrgilang.data.searchuser.mapper.toDomain
import com.arifrgilang.data.searchuser.repository.source.SearchUserEntityDataFactory
import com.arifrgilang.data.util.SourceType
import com.arifrgilang.domain.searchuser.model.User
import com.arifrgilang.domain.searchuser.repository.SearchUserRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version SearchUserEntityRepository, v 2.0 25/02/22 11.14 by Arif R Gilang P
 */
class SearchUserEntityRepository @Inject constructor(
    private val searchUserRepoFactory: SearchUserEntityDataFactory
) : SearchUserRepository {

//    private val localRepository =
//        searchUserRepoFactory.createSearchUserEntityData(SourceType.PERSISTENCE)

    private fun getRemoteRepository() =
        searchUserRepoFactory.createSearchUserEntityData(SourceType.NETWORK)

    override fun searchUsers(username: String, refresh: Boolean): Observable<List<User>> {
        // TODO: Add handle for local caching for next feature
        return searchUsersFromRemote(username)
    }

    override fun getUser(username: String, refresh: Boolean): Observable<User> {
        // TODO: Add handle for local caching for next feature
        return getUserFromRemote(username)
    }

//    private fun searchUsersFromLocal(
//        username: String
//    ): Observable<List<User>> {
//        return localRepository.searchUsers(username).flatMap { list ->
//            Observable.fromIterable(list)
//                .map { it.toDomain() }
//                .toList()
//                .toObservable()
//        }
//    }

    private fun searchUsersFromRemote(
        username: String
    ): Observable<List<User>> {
        return getRemoteRepository().searchUsers(username).flatMap { list ->
            Observable.fromIterable(list)
                .map { it.toDomain() }
                .toList()
                .toObservable()
        }
    }

//    private fun getUserFromLocal(
//        username: String
//    ): Observable<User> {
//        return localRepository.getUserProfile(username).map { it.toDomain() }
//    }

    private fun getUserFromRemote(
        username: String
    ): Observable<User> {
        return getRemoteRepository().getUserProfile(username).map { it.toDomain() }
    }
}