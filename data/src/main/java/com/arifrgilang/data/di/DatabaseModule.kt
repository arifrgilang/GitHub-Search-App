/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.data.di

import android.content.Context
import androidx.room.Room
import com.arifrgilang.data.network.Constant
import com.arifrgilang.data.searchuser.repository.source.local.dao.UserEntityDao
import com.arifrgilang.data.searchuser.repository.source.local.db.GitHubDatabase
import com.arifrgilang.data.util.DataStoreHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version DatabaseModule, v 2.0 02/03/22 10.39 by Arif R Gilang P
 */
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        context: Context
    ) = Room.databaseBuilder(
        context,
        GitHubDatabase::class.java,
        Constant.Database.DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideUserDao(
        database: GitHubDatabase
    ): UserEntityDao =
        database.listUserDao()

    @Singleton
    @Provides
    fun provideDataStoreHelper() = DataStoreHelper()
}