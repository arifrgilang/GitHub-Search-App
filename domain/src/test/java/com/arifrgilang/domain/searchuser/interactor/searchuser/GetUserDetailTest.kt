/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.domain.searchuser.interactor.searchuser

import com.arifrgilang.domain.searchuser.interactor.GetUserDetail
import com.arifrgilang.domain.searchuser.interactor.base.RxJavaUseCaseTesting
import com.arifrgilang.domain.searchuser.model.GetUserDetailRequest
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
 * @version GetUserDetailTest, v 2.0 04/03/22 17.58 by Arif R Gilang P
 */
class GetUserDetailTest : RxJavaUseCaseTesting() {

    private var searchUserRepository = mockk<SearchUserRepository>(relaxed = true)
    private var getUserDetail = GetUserDetail(searchUserRepository)

    @Test
    fun `buildUseCase should invoke searchUserRepository#getUser`() {
        val requestInfo = GetUserDetail.Params.createGetUserDetailRequest(
            GetUserDetailRequest("arifrgilang", true)
        )
        val getUserDetailResult = mockGetUsersDetailResult()
        //given
        every { searchUserRepository.getUser(any(), any()) } returns Observable.just(
            getUserDetailResult
        )
        //when
        getUserDetail.buildUseCase(requestInfo)
        //then
        verify { searchUserRepository.getUser(any(), any()) }
    }

    @After
    fun tearDown() {
        getUserDetail.dispose()
    }

    private fun mockGetUsersDetailResult() =
        User(
            1,
            "arifrgilang",
            "Arif R Gilang",
            "https://avatars.githubusercontent.com/u/36944464?v=4",
            "Android Developer", 33, 134, "Bandung - Jatinangor",
            "arifrgilang@gmail.com"
        )
}