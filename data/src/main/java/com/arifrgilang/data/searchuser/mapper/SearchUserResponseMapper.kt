/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.data.searchuser.mapper

import com.arifrgilang.data.searchuser.model.UserEntity
import com.arifrgilang.data.searchuser.repository.source.network.response.UserResponse
import com.arifrgilang.domain.searchuser.model.User

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version SearchUserNetworkMapper, v 2.0 25/02/22 12.27 by Arif R Gilang P
 */
fun UserResponse.toDomain(): User {
    return User(
        this.id,
        this.login,
        this.name,
        this.avatarUrl,
        this.bio,
        this.followers,
        this.following,
        this.location,
        this.email
    )
}

fun UserResponse.toEntity(): UserEntity {
    return UserEntity(
        this.id,
        this.login,
        this.name,
        this.avatarUrl,
        this.bio,
        this.followers,
        this.following,
        this.location,
        this.email
    )
}
