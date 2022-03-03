/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.data.searchuser.repository.source.local

import com.arifrgilang.data.searchuser.mapper.toEntity
import com.arifrgilang.data.searchuser.model.UserEntity
import com.arifrgilang.data.searchuser.repository.source.SearchUserEntityData
import com.arifrgilang.data.searchuser.repository.source.local.dao.UserEntityDao
import com.arifrgilang.data.util.DataStoreHelper
import com.arifrgilang.domain.searchuser.model.User
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version PersistenceSearchUserEntityData, v 2.0 25/02/22 11.16 by Arif R Gilang P
 */
class PersistenceSearchUserEntityData @Inject constructor(
    private val userEntityDao: UserEntityDao,
    private val dataStoreHelper: DataStoreHelper
) : SearchUserEntityData {

    override fun searchUsers(username: String): Observable<List<UserEntity>> {
        return Observable.defer {
            val result = userEntityDao.searchUsers(username)
            Observable.just(result)
        }
    }

    override fun getUserProfile(username: String): Observable<UserEntity> {
        return Observable.defer {
            val result = userEntityDao.getUser(username)
            Observable.just(result)
        }
    }

    fun insertAllAndSearchUsers(
        username: String,
        users: List<User>
    ): Observable<List<UserEntity>> {
        userEntityDao.insertAll(users.map { it.toEntity() })
        setLastCacheTime(DataStoreHelper.KEY_SEARCH_USERS, System.currentTimeMillis())
        return searchUsers(username)
    }

    fun updateUser(
        user: User
    ): Observable<UserEntity> {
        userEntityDao.updateUser(user.toEntity())
        setLastCacheTime(DataStoreHelper.KEY_GET_USER, System.currentTimeMillis())
        return getUserProfile(user.username!!)
    }

    private fun setLastCacheTime(key: String, lastCache: Long) {
        dataStoreHelper.setCacheTime(key, lastCache)
    }

    private fun getLastCacheUpdateTimeMillis(key: String): Long =
        dataStoreHelper.getLastCacheTime(key)

    fun isExpired(key: String): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdateTime = getLastCacheUpdateTimeMillis(key)
        return currentTime - lastUpdateTime > EXPIRATION_TIME
    }

    companion object {

        private const val EXPIRATION_TIME = (60 * 10 * 1000).toLong() //10 Minute
    }
}