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
import com.arifrgilang.data.searchuser.repository.source.local.PersistenceSearchUserEntityData
import com.arifrgilang.data.util.SourceType
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
    private val localRepository = mockk<PersistenceSearchUserEntityData>()
    private val remoteRepository = mockk<SearchUserEntityData>()
    private val repository = SearchUserEntityRepository(dataFactory)

    @Before
    fun setUp() {
        every { dataFactory.createSearchUserEntityData(SourceType.PERSISTENCE) } returns localRepository
        every { dataFactory.createSearchUserEntityData(SourceType.NETWORK) } returns remoteRepository
    }

    @Test
    fun `searchUsers with refresh=false and isExpired=false shouldInvoke localRepository#searchUsers`() {
        val searchUsersResult = mockSearchUsersResult()
        //given
        every { localRepository.isExpired(any()) } returns false
        every { localRepository.searchUsers(any()) } returns Observable.just(searchUsersResult)
        every { remoteRepository.searchUsers(any()) } returns Observable.just(searchUsersResult)
        //when
        repository.searchUsers("arifrgilang", false)
        //then
        verify(exactly = 1) { localRepository.searchUsers(any()) }
        verify(exactly = 1) { localRepository.isExpired(any()) }
        verify(exactly = 0) { remoteRepository.searchUsers(any()) }
    }

    @Test
    fun `searchUsers with refresh=false and isExpired=true shouldInvoke remoteRepository#searchUsers`() {
        val searchUsersResult = mockSearchUsersResult()
        //given
        every { localRepository.isExpired(any()) } returns true
        every { localRepository.searchUsers(any()) } returns Observable.just(searchUsersResult)
        every { remoteRepository.searchUsers(any()) } returns Observable.just(searchUsersResult)
        //when
        repository.searchUsers("arifrgilang", false)
        //then
        verify(exactly = 1) { localRepository.searchUsers(any()) }
        verify(exactly = 1) { localRepository.isExpired(any()) }
        verify(exactly = 1) { remoteRepository.searchUsers(any()) }
    }

    @Test
    fun `searchUsers with refresh=true and isExpired=false shouldInvoke remoteRepository#searchUsers`() {
        val searchUsersResult = mockSearchUsersResult()
        //given
        every { localRepository.isExpired(any()) } returns false
        every { localRepository.searchUsers(any()) } returns Observable.just(searchUsersResult)
        every { remoteRepository.searchUsers(any()) } returns Observable.just(searchUsersResult)
        //when
        repository.searchUsers("arifrgilang", true)
        //then
        verify(exactly = 1) { localRepository.searchUsers(any()) }
        verify(exactly = 0) { localRepository.isExpired(any()) }
        verify(exactly = 1) { remoteRepository.searchUsers(any()) }
    }

    @Test
    fun `searchUsers with refresh=true and isExpired=true shouldInvoke remoteRepository#searchUsers`() {
        val searchUsersResult = mockSearchUsersResult()
        //given
        every { localRepository.isExpired(any()) } returns true
        every { localRepository.searchUsers(any()) } returns Observable.just(searchUsersResult)
        every { remoteRepository.searchUsers(any()) } returns Observable.just(searchUsersResult)
        //when
        repository.searchUsers("arifrgilang", true)
        //then
        verify(exactly = 1) { localRepository.searchUsers(any()) }
        verify(exactly = 0) { localRepository.isExpired(any()) }
        verify(exactly = 1) { remoteRepository.searchUsers(any()) }
    }

    @Test
    fun `getUser with refresh=false and isExpired=false should invoke localRepository#getUserProfile`() {
        val getUserDetailResult = mockGetUserDetailResult()
        //given
        every { localRepository.isExpired(any()) } returns false
        every { localRepository.getUserProfile(any()) } returns Observable.just(getUserDetailResult)
        every { remoteRepository.getUserProfile(any()) } returns Observable.just(getUserDetailResult)
        //when
        repository.getUser("arifrgilang", false)
        //then
        verify(exactly = 1) { localRepository.getUserProfile(any()) }
        verify(exactly = 1) { localRepository.isExpired(any()) }
        verify(exactly = 0) { remoteRepository.getUserProfile(any()) }
    }

    @Test
    fun `getUser with refresh=false and isExpired=true should invoke remoteRepository#getUserProfile`() {
        val getUserDetailResult = mockGetUserDetailResult()
        //given
        every { localRepository.isExpired(any()) } returns true
        every { localRepository.getUserProfile(any()) } returns Observable.just(getUserDetailResult)
        every { remoteRepository.getUserProfile(any()) } returns Observable.just(getUserDetailResult)
        //when
        repository.getUser("arifrgilang", false)
        //then
        verify(exactly = 1) { localRepository.getUserProfile(any()) }
        verify(exactly = 1) { localRepository.isExpired(any()) }
        verify(exactly = 1) { remoteRepository.getUserProfile(any()) }
    }

    @Test
    fun `getUser with refresh=true and isExpired=false should invoke remoteRepository#getUserProfile`() {
        val getUserDetailResult = mockGetUserDetailResult()
        //given
        every { localRepository.isExpired(any()) } returns false
        every { localRepository.getUserProfile(any()) } returns Observable.just(getUserDetailResult)
        every { remoteRepository.getUserProfile(any()) } returns Observable.just(getUserDetailResult)
        //when
        repository.getUser("arifrgilang", true)
        //then
        verify(exactly = 1) { localRepository.getUserProfile(any()) }
        verify(exactly = 0) { localRepository.isExpired(any()) }
        verify(exactly = 1) { remoteRepository.getUserProfile(any()) }
    }

    @Test
    fun `getUser with refresh=true and isExpired=true should invoke remoteRepository#getUserProfile`() {
        val getUserDetailResult = mockGetUserDetailResult()
        //given
        every { localRepository.isExpired(any()) } returns true
        every { localRepository.getUserProfile(any()) } returns Observable.just(getUserDetailResult)
        every { remoteRepository.getUserProfile(any()) } returns Observable.just(getUserDetailResult)
        //when
        repository.getUser("arifrgilang", true)
        //then
        verify(exactly = 1) { localRepository.getUserProfile(any()) }
        verify(exactly = 0) { localRepository.isExpired(any()) }
        verify(exactly = 1) { remoteRepository.getUserProfile(any()) }
    }

    private fun mockSearchUsersResult() = arrayListOf(
        UserEntity(
            1,
            "arifrgilang",
            "Arif R Gilang",
            "https://avatars.githubusercontent.com/u/36944464?v=4",
            "Android Developer", 33, 134, "Bandung - Jatinangor",
            "arifrgilang@gmail.com"
        )
    )

    private fun mockGetUserDetailResult() =
        UserEntity(
            1,
            "arifrgilang",
            "Arif R Gilang",
            "https://avatars.githubusercontent.com/u/36944464?v=4",
            "Android Developer", 33, 134, "Bandung - Jatinangor",
            "arifrgilang@gmail.com"
        )
}