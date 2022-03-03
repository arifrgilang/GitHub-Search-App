/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.data.searchuser.repository.source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.arifrgilang.data.searchuser.model.UserEntity
import com.arifrgilang.data.searchuser.repository.source.local.dao.UserEntityDao

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version GitHubDatabase, v 2.0 01/03/22 12.02 by Arif R Gilang P
 */
@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class GitHubDatabase : RoomDatabase() {

    abstract fun listUserDao(): UserEntityDao
}