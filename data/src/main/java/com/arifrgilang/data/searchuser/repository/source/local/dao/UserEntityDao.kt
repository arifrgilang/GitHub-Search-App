/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.data.searchuser.repository.source.local.dao

import androidx.room.*
import com.arifrgilang.data.network.Constant.Database
import com.arifrgilang.data.searchuser.model.UserEntity
import io.reactivex.Observable

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version UserEntityDao, v 2.0 01/03/22 10.30 by Arif R Gilang P
 */
@Dao
interface UserEntityDao {

    @Query("SELECT * FROM ${Database.Table.USER} WHERE username LIKE '%' || :username || '%'")
    fun searchUsers(username: String): Observable<List<UserEntity>>

    @Query("SELECT * FROM ${Database.Table.USER} WHERE username=:username")
    fun getUser(username: String): Observable<UserEntity>

    @Update
    fun updateUser(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<UserEntity>)
}