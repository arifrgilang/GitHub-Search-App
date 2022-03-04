/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.githubsearchapp.userdetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.view.isVisible
import com.arifrgilang.githubsearchapp.R
import com.arifrgilang.githubsearchapp.base.BaseBindingActivity
import com.arifrgilang.githubsearchapp.databinding.ActivityUserDetailBinding
import com.arifrgilang.githubsearchapp.di.component.DaggerGetUserProfileComponent
import com.arifrgilang.githubsearchapp.di.module.GetUserProfileModule
import com.arifrgilang.githubsearchapp.searchuser.model.UserModel
import timber.log.Timber
import javax.inject.Inject

class UserDetailActivity : BaseBindingActivity<ActivityUserDetailBinding>() {

    companion object {

        private const val KEY_INTENT_USERNAME = "[username]"

        fun createIntent(context: Context, username: String): Intent {
            return Intent(context, UserDetailActivity::class.java).putExtra(
                KEY_INTENT_USERNAME,
                username
            )
        }
    }

    @Inject
    lateinit var presenter: UserDetailContract.Presenter

    private lateinit var usernameIntent: String

    override fun contentView(): Int = R.layout.activity_user_detail

    override fun setupData(savedInstanceState: Bundle?) {
        intent.getStringExtra(KEY_INTENT_USERNAME)?.let {
            usernameIntent = it
        }
    }

    override fun setupView() {
        initInjector()
        usernameIntent.let {
            presenter.getUserDetail(it, true)
        }
        binding.slUserDetail.setOnRefreshListener {
            presenter.getUserDetail(usernameIntent, true)
        }
    }

    private fun initInjector() {
        DaggerGetUserProfileComponent.builder()
            .applicationComponent(getApplicationComponent())
            .getUserProfileModule(getUserProfileModule())
            .build()
            .inject(this)
    }

    private fun getUserProfileModule() = GetUserProfileModule(object : UserDetailContract.View {
        override fun setUserResult(user: UserModel) {
            binding.user = user
        }

        override fun showProgress() {
            binding.slUserDetail.isRefreshing = true
            binding.clUserDetail.isVisible = false
        }

        override fun dismissProgress() {
            binding.slUserDetail.isRefreshing = false
            binding.clUserDetail.isVisible = true
        }

        override fun onError(errorMessage: String?) {
            Timber.e(errorMessage)
        }
    })
}