/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.domain.searchuser.model

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version SearchUserRequest, v 2.0 04/03/22 07.02 by Arif R Gilang P
 */
data class SearchUsersRequest(val username: String, val refresh: Boolean)