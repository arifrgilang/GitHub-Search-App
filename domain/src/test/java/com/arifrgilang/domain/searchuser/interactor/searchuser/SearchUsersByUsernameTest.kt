/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.domain.searchuser.interactor.searchuser

import com.arifrgilang.domain.searchuser.interactor.SearchUsersByUsername
import com.arifrgilang.domain.searchuser.interactor.base.RxJavaUseCaseTesting
import com.arifrgilang.domain.searchuser.model.SearchUsersRequest
import com.arifrgilang.domain.searchuser.model.User
import com.arifrgilang.domain.searchuser.repository.SearchUserRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Observable
import org.junit.After
import org.junit.Test

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version GetUsersByUsernameTest, v 2.0 03/03/22 13.50 by Arif R Gilang P
 */
class SearchUsersByUsernameTest : RxJavaUseCaseTesting() {

    private var searchUserRepository = mockk<SearchUserRepository>(relaxed = true)
    private var searchUsersByUsername = SearchUsersByUsername(searchUserRepository)

    @Test
    fun `buildUseCase should invoke searchUserRepository#searchUsers`() {
        val requestInfo = SearchUsersByUsername.Params.createSearchUserRequest(
            SearchUsersRequest("arifrgilang", true)
        )
        val searchUserResult = mockSearchUsersResult()
        //given
        every { searchUserRepository.searchUsers(any(), any()) } returns Observable.just(
            searchUserResult
        )
        //when
        searchUsersByUsername.buildUseCase(requestInfo)
        //then
        verify { searchUserRepository.searchUsers(any(), any()) }
    }

    @After
    fun tearDown() {
        searchUsersByUsername.dispose()
    }

    private fun mockSearchUsersResult() = arrayListOf(
        User(
            1,
            "arifrgilang",
            "Arif R Gilang",
            "https://avatars.githubusercontent.com/u/36944464?v=4",
            "Android Developer", 33, 134, "Bandung - Jatinangor",
            "arifrgilang@gmail.com"
        )
    )

}