/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.githubsearchapp.searchuser

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.arifrgilang.data.searchuser.model.UserEntity
import com.arifrgilang.domain.base.OnSuccessCallback
import com.arifrgilang.domain.searchuser.interactor.GetUsersByUsername
import com.arifrgilang.domain.searchuser.model.User
import com.arifrgilang.githubsearchapp.searchuser.mapper.toModel
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version SearchUserPresenterTest, v 2.0 03/03/22 15.53 by Arif R Gilang P
 */
class SearchUserPresenterTest {

    private val getUsersByUsername = mockk<GetUsersByUsername>()
    private val view = mockk<SearchUserContract.View>(relaxed = true)
    private val presenter = spyk(SearchUserPresenter(view, getUsersByUsername))

    @Test
    fun `searchUsers shouldCall view#setUserResult when success`() {
        val listUsers = arrayListOf(
            User(
                1,
                "arifrgilang",
                "Arif R Gilang",
                "https://avatars.githubusercontent.com/u/36944464?v=4",
                "Android Developer", 33, 134, "Bandung - Jatinangor",
                "arifrgilang@gmail.com"
            )
        )

        every { getUsersByUsername.execute(any(), any(), any()) } answers {
            secondArg<OnSuccessCallback<List<User>>>().invoke(listUsers)
        }

        presenter.searchUsers("arifrgilang")

        verify {
            view.showProgress() //no answer found for this
            view.setUserResult(any())
            view.dismissProgress()
        }
    }
}