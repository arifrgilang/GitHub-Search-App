/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.githubsearchapp.searchuser.mapper

import com.arifrgilang.domain.searchuser.model.User
import com.arifrgilang.githubsearchapp.searchuser.model.UserModel

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version UserModelMapper, v 2.0 2/24/2022 3:18 PM by Arif R Gilang P
 */
fun User.toModel() = UserModel(
    id = id,
    username = username,
    name = name,
    imageUrl = imageUrl,
    bio = bio,
    followers = followers,
    following = following,
    location = location,
    email = email
)

fun UserModel.toDomain() = User(
    id = id,
    username = username,
    name = name,
    imageUrl = imageUrl,
    bio = bio,
    followers = followers,
    following = following,
    location = location,
    email = email
)