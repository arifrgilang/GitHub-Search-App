/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.data.searchuser.repository

import com.arifrgilang.data.searchuser.mapper.toDomain
import com.arifrgilang.data.searchuser.model.UserEntity
import com.arifrgilang.data.searchuser.repository.source.SearchUserEntityDataFactory
import com.arifrgilang.data.searchuser.repository.source.local.PersistenceSearchUserEntityData
import com.arifrgilang.data.util.DataStoreHelper
import com.arifrgilang.data.util.SourceType
import com.arifrgilang.domain.searchuser.model.User
import com.arifrgilang.domain.searchuser.repository.SearchUserRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version SearchUserEntityRepository, v 2.0 25/02/22 11.14 by Arif R Gilang P
 */
class SearchUserEntityRepository @Inject constructor(
    private val searchUserRepoFactory: SearchUserEntityDataFactory
) : SearchUserRepository {

    private fun getLocalRepository() =
        searchUserRepoFactory.createSearchUserEntityData(SourceType.PERSISTENCE)

    private fun getRemoteRepository() =
        searchUserRepoFactory.createSearchUserEntityData(SourceType.NETWORK)

    override fun searchUsers(
        username: String,
        refresh: Boolean
    ): Observable<List<User>> {
        val userLocalList = searchUsersFromLocal(username).blockingFirst()
        return if (userLocalList.isNotEmpty() && !refresh) {
            if (isCacheTimeExpired(DataStoreHelper.KEY_SEARCH_USERS)) {
                searchUsersFromRemote(username)
            } else {
                Observable.just(userLocalList)
            }
        } else {
            searchUsersFromRemote(username)
        }
    }

    override fun getUser(
        username: String,
        refresh: Boolean
    ): Observable<User> {
        val userLocal = getUserFromLocal(username).blockingFirst()
        return if(!refresh) {
            if(isCacheTimeExpired(DataStoreHelper.KEY_GET_USER)) {
                getUserFromRemote(username)
            } else {
                Observable.just(userLocal)
            }
        } else {
            getUserFromRemote(username)
        }
    }

    private fun searchUsersFromLocal(
        username: String
    ): Observable<List<User>> {
        return getLocalRepository().searchUsers(username)
            .flatMap { it.mapListToDomain() }
    }

    private fun searchUsersFromRemote(
        username: String
    ): Observable<List<User>> {
        return getRemoteRepository().searchUsers(username)
            .flatMap { userSearchResult ->
                if (userSearchResult.isNotEmpty()) {
                    (getLocalRepository() as PersistenceSearchUserEntityData)
                        .insertAllAndSearchUsers(username, userSearchResult.map { it.toDomain() })
                        .subscribeOn(Schedulers.io())
                        .flatMap { it.mapListToDomain() }
                        .subscribe()
                }
                userSearchResult.mapListToDomain()
            }
    }

    private fun getUserFromLocal(
        username: String
    ): Observable<User> {
        return getLocalRepository().getUserProfile(username).map { it.toDomain() }
    }

    private fun getUserFromRemote(
        username: String
    ): Observable<User> {
        return getRemoteRepository().getUserProfile(username).map { it.toDomain() }
    }

    private fun List<UserEntity>.mapListToDomain() =
        Observable.fromIterable(this)
            .map { it.toDomain() }
            .toList()
            .toObservable()

    private fun isCacheTimeExpired(key: String) =
        (getLocalRepository() as PersistenceSearchUserEntityData)
            .isExpired(key)
}