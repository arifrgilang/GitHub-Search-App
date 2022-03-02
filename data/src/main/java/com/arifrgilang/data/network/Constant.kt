/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.data.network

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version Constant, v 2.0 25/02/22 11.42 by Arif R Gilang P
 */
object Constant {

    object Database {

        const val DATABASE_NAME = "GitHub_DATABASE"

        object Table {

            const val USER = "user_entity"
        }
    }

    object Network {
        object Search {

            private const val PREFIX = "search"
            const val USERS = "$PREFIX/users"
        }

        object User {

            private const val PREFIX = "users"
            const val PROFILE = "$PREFIX/{param}"
        }
    }
}