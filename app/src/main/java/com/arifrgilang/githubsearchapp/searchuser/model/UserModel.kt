/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.githubsearchapp.searchuser.model

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version UserModel, v 2.0 2/24/2022 3:08 PM by Arif R Gilang P
 */
data class UserModel(
    var id: Int,
    var username: String? = null,
    var name: String? = null,
    var imageUrl: String? = null,
    var bio: String? = null,
    var followers: Int? = null,
    var following: Int? = null,
    var location: String? = null,
    var email: String? = null,
)
