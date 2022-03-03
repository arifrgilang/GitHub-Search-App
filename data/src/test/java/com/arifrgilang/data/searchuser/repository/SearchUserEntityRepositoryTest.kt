/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.data.searchuser.repository

import com.arifrgilang.data.searchuser.model.UserEntity
import com.arifrgilang.data.searchuser.repository.source.SearchUserEntityData
import com.arifrgilang.data.searchuser.repository.source.SearchUserEntityDataFactory
import com.arifrgilang.data.searchuser.repository.source.network.NetworkSearchUserEntityData
import com.arifrgilang.data.util.SourceType
import com.arifrgilang.domain.searchuser.model.User
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version SearchUserEntityRepositoryTest, v 2.0 03/03/22 15.05 by Arif R Gilang P
 */
class SearchUserEntityRepositoryTest() {

    private val dataFactory = mockk<SearchUserEntityDataFactory>()
    private val networkRepository = mockk<SearchUserEntityData>()
    private val mockRepository = mockk<SearchUserEntityData>()
    private val repository = SearchUserEntityRepository(dataFactory)

    @Before
    fun setUp() {
        every { dataFactory.createSearchUserEntityData(SourceType.NETWORK) } returns networkRepository
        every { dataFactory.createSearchUserEntityData(SourceType.MOCK) } returns mockRepository
    }

    @Test
    fun searchUsersFromRepository_shouldUseNetworkRepository() {
        val listUsers = arrayListOf(
            UserEntity(
                1,
                "arifrgilang",
                "Arif R Gilang",
                "https://avatars.githubusercontent.com/u/36944464?v=4",
                "Android Developer", 33, 134, "Bandung - Jatinangor",
                "arifrgilang@gmail.com"
            )
        )
        //given
        every { networkRepository.searchUsers(any()) } returns Observable.just(listUsers)

        //when
        repository.searchUsers("arifrgilang", true)

        //then
        verify { networkRepository.searchUsers(any()) }
        verify(exactly = 0) { mockRepository.searchUsers(any()) }
    }
}