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
 * @version GetUserProfileRequest, v 2.0 04/03/22 16.41 by Arif R Gilang P
 */
data class GetUserDetailRequest(val username: String, val refresh: Boolean)