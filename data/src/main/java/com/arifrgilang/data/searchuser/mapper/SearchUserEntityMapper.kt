/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.data.searchuser.mapper

import com.arifrgilang.data.searchuser.model.UserEntity
import com.arifrgilang.domain.searchuser.model.User

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version SearchUserEntityMapper, v 2.0 25/02/22 12.27 by Arif R Gilang P
 */
fun User.toEntity(): UserEntity {
    return UserEntity(
        this.id,
        this.username,
        this.name,
        this.imageUrl,
        this.bio,
        this.followers,
        this.following,
        this.location,
        this.email
    )
}

internal fun UserEntity.toDomain(): User {
    return User(
        this.id,
        this.username,
        this.name,
        this.imageUrl,
        this.bio,
        this.followers,
        this.following,
        this.location,
        this.email
    )
}