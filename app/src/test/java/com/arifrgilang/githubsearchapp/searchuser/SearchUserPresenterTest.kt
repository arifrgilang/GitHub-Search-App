/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.githubsearchapp.searchuser

import com.arifrgilang.domain.base.OnSuccessCallback
import com.arifrgilang.domain.searchuser.interactor.SearchUsersByUsername
import com.arifrgilang.domain.searchuser.model.User
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.Test

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version SearchUserPresenterTest, v 2.0 03/03/22 15.53 by Arif R Gilang P
 */
class SearchUserPresenterTest {

    private val getUsersByUsername = mockk<SearchUsersByUsername>()
    private val view = mockk<SearchUserContract.View>(relaxed = true)
    private val presenter = spyk(SearchUserPresenter(view, getUsersByUsername))

    @Test
    fun `searchUsers shouldCall view#setUserResult when success`() {
        val searchUserResult = mockSearchUsersResult()

        every { getUsersByUsername.execute(any(), any(), any()) } answers {
            secondArg<OnSuccessCallback<List<User>>>().invoke(searchUserResult)
        }

        presenter.searchUsers("arifrgilang")

        verify {
            view.showProgress()
            view.setUserResult(any())
            view.dismissProgress()
        }
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