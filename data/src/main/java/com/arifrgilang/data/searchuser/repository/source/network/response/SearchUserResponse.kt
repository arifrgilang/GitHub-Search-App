/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.data.searchuser.repository.source.network.response

import com.google.gson.annotations.SerializedName

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version SearchUserResponse, v 2.0 25/02/22 11.50 by Arif R Gilang P
 */
data class SearchUserResponse(
    @SerializedName("total_count")
    var totalCount: Int? = null,
    @SerializedName("incomplete_results")
    var incompleteResult: Boolean? = null,
    @SerializedName("items")
    var items: List<UserResponse>? = null
)
