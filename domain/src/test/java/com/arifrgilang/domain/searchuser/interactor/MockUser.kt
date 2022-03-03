/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.domain.searchuser.interactor

import com.arifrgilang.domain.searchuser.model.User

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version Mock, v 2.0 03/03/22 14.12 by Arif R Gilang P
 */
object MockUser {

    val oneUser: User
        get() = User(
            1,
            "arifrgilang",
            "Arif R Gilang",
            "https://avatars.githubusercontent.com/u/36944464?v=4",
            "Android Developer", 33, 134, "Bandung - Jatinangor",
            "arifrgilang@gmail.com"
        )
}
