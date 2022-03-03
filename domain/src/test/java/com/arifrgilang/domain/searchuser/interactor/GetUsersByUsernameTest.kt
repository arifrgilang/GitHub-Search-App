/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.domain.searchuser.interactor

import com.arifrgilang.domain.searchuser.model.User
import com.arifrgilang.domain.searchuser.repository.SearchUserRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Observable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version GetUsersByUsernameTest, v 2.0 03/03/22 13.50 by Arif R Gilang P
 */
class GetUsersByUsernameTest {

    private var searchUserRepository = mockk<SearchUserRepository>(relaxed = true)
    private var getUsersByUsername = GetUsersByUsername(searchUserRepository)

    @Before
    fun setUp() {
        RxAndroidPlugins.setMainThreadSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
    }

    @Test
    fun buildUseCaseObservable_shouldReturn_users() {
        val userList = arrayListOf(
            User(
                1,
                "arifrgilang",
                "Arif R Gilang",
                "https://avatars.githubusercontent.com/u/36944464?v=4",
                "Android Developer", 33, 134, "Bandung - Jatinangor",
                "arifrgilang@gmail.com"
            )
        )
        //given
        every { searchUserRepository.searchUsers(any(), any()) } returns Observable.just(userList)

        //when
        getUsersByUsername.buildUseCase(GetUsersByUsername.Params("arifrgilang", true))

        //then
        verify { searchUserRepository.searchUsers(any(), any()) }
    }

    @After
    fun tearDown() {
        getUsersByUsername.dispose()
    }

}