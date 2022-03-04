/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.data.searchuser.repository.source

import com.arifrgilang.data.searchuser.repository.source.local.PersistenceSearchUserEntityData
import com.arifrgilang.data.searchuser.repository.source.mock.MockSearchUserEntityData
import com.arifrgilang.data.searchuser.repository.source.network.NetworkSearchUserEntityData
import com.arifrgilang.data.util.SourceType
import javax.inject.Inject

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version SearchUserDataFactory, v 2.0 25/02/22 11.15 by Arif R Gilang P
 */
class SearchUserEntityDataFactory @Inject constructor(
    private val persistenceEntityData: PersistenceSearchUserEntityData,
    private val mockEntityData: MockSearchUserEntityData,
    private val networkEntityData: NetworkSearchUserEntityData
) {

    fun createSearchUserEntityData(source: SourceType): SearchUserEntityData =
        when (source) {
            SourceType.MOCK -> mockEntityData
            SourceType.NETWORK -> networkEntityData
            SourceType.PERSISTENCE -> persistenceEntityData
        }

}