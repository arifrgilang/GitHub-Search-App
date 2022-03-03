/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.data.util

import com.tencent.mmkv.MMKV
import javax.inject.Inject

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version DataStoreHelper, v 2.0 01/03/22 10.35 by Arif R Gilang P
 */
class DataStoreHelper @Inject constructor() {

    companion object {

        private const val DATA_STORE_NAME = "CACHE_DATASTORE"
        const val KEY_SEARCH_USERS = "last_search_users"
        const val KEY_GET_USER = "last_get_user"
    }

    fun setCacheTime(key: String, time: Long) {
        MMKV.defaultMMKV().encode(key, time)
    }

    fun clearCacheTime(key: String) {
        MMKV.defaultMMKV().encode(key, 0L)
    }

    fun getLastCacheTime(key: String): Long {
        return MMKV.defaultMMKV().decodeLong(key)
    }
}