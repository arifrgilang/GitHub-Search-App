/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.data.searchuser.model

import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.arifrgilang.data.network.Constant

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version UserEntity, v 2.0 25/02/22 11.34 by Arif R Gilang P
 */
@Entity(tableName = Constant.Database.Table.USER)
data class UserEntity (
    @PrimaryKey
    val id: Int,

    @ColumnInfo(defaultValue = "")
    @Nullable
    val username: String?,

    @ColumnInfo(defaultValue = "")
    @Nullable
    val name: String?,

    @ColumnInfo(defaultValue="", name = "image_url")
    @Nullable
    val imageUrl: String?,

    @ColumnInfo(defaultValue = "")
    @Nullable
    var bio: String?,

    @ColumnInfo(defaultValue = "0")
    @Nullable
    var followers: Int?,

    @ColumnInfo(defaultValue = "0")
    @Nullable
    var following: Int?,

    @ColumnInfo(defaultValue = "")
    @Nullable
    var location: String?,

    @ColumnInfo(defaultValue = "")
    @Nullable
    var email: String?,
)