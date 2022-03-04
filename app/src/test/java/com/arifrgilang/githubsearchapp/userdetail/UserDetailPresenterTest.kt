/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.githubsearchapp.userdetail

import com.arifrgilang.domain.base.OnErrorCallback
import com.arifrgilang.domain.base.OnSuccessCallback
import com.arifrgilang.domain.searchuser.interactor.GetUserDetail
import com.arifrgilang.domain.searchuser.model.User
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.Test

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version UserDetailPresenterTest, v 2.0 04/03/22 19.05 by Arif R Gilang P
 */
class UserDetailPresenterTest {

    private val getUserDetail = mockk<GetUserDetail>()
    private val view = mockk<UserDetailContract.View>(relaxed = true)
    private val presenter = spyk(UserDetailPresenter(view, getUserDetail))

    @Test
    fun `getUserDetail shouldCall view#setUserResult when success`() {
        val userDetailResult = mockUserDetailResult()
        //given
        every { getUserDetail.execute(any(), any(), any()) } answers {
            secondArg<OnSuccessCallback<User>>().invoke(userDetailResult)
        }
        //when
        presenter.getUserDetail("arifrgilang", true)
        //then
        verify {
            view.showProgress()
            view.setUserResult(any())
            view.dismissProgress()
        }
    }

    @Test
    fun `getUserDetail shouldCall view#onError when failed`() {
        val userDetailResult = mockUserDetailResult()
        //given
        every { getUserDetail.execute(any(), any(), any()) } answers {
            thirdArg<OnErrorCallback>().invoke(Throwable("error"))
        }
        //when
        presenter.getUserDetail("arifrgilang", true)
        //then
        verify {
            view.showProgress()
            view.onError(any())
            view.dismissProgress()
        }
    }

    private fun mockUserDetailResult() =
        User(
            1,
            "arifrgilang",
            "Arif R Gilang",
            "https://avatars.githubusercontent.com/u/36944464?v=4",
            "Android Developer", 33, 134, "Bandung - Jatinangor",
            "arifrgilang@gmail.com"
        )
}