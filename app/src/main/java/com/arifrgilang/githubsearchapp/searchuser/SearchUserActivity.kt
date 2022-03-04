/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.githubsearchapp.searchuser

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.arifrgilang.githubsearchapp.GitHubSearchApp
import com.arifrgilang.githubsearchapp.R
import com.arifrgilang.githubsearchapp.base.BaseBindingActivity
import com.arifrgilang.githubsearchapp.databinding.ActivitySearchUserBinding
import com.arifrgilang.githubsearchapp.di.component.DaggerSearchUsersComponent
import com.arifrgilang.githubsearchapp.di.module.SearchUserModule
import com.arifrgilang.githubsearchapp.searchuser.adapter.SearchUserAdapter
import com.arifrgilang.githubsearchapp.searchuser.model.UserModel
import com.arifrgilang.githubsearchapp.util.CustomRvMargin
import timber.log.Timber
import javax.inject.Inject

class SearchUserActivity : BaseBindingActivity<ActivitySearchUserBinding>() {

    @Inject
    lateinit var rvAdapter: SearchUserAdapter

    @Inject
    lateinit var presenter: SearchUserContract.Presenter

    override fun contentView(): Int = R.layout.activity_search_user

    override fun setupData(savedInstanceState: Bundle?) {}

    override fun setupView() {
        initInjector()
        initRecyclerView()
        binding.srlSearch.setOnRefreshListener {
            performSearchUser(refresh = true)
        }
        binding.etSearchUser.setOnEditorActionListener { _, i, _ ->
            if (i == EditorInfo.IME_ACTION_SEARCH) {
                performSearchUser(refresh = false)
            }
            false
        }
    }

    private fun initInjector() {
        DaggerSearchUsersComponent.builder()
            .applicationComponent((application as GitHubSearchApp).getApplicationComponent())
            .searchUserModule(getSearchUserModule())
            .build()
            .inject(this)
    }

    private fun getSearchUserModule() = SearchUserModule(object : SearchUserContract.View {
        override fun setUserResult(users: List<UserModel>) {
            if (users.isEmpty()) {
                binding.tvSearchNoItem.isVisible = true
                binding.rvSearchUsers.isVisible = false
            } else {
                binding.tvSearchNoItem.isVisible = false
                binding.rvSearchUsers.isVisible = true
                rvAdapter.clearAndNotify()
                Timber.d("RESUlT: $users")
                rvAdapter.insertAndNotify(users)
            }
        }

        override fun showProgress() {
            binding.srlSearch.isRefreshing = true
        }

        override fun dismissProgress() {
            binding.srlSearch.isRefreshing = false
        }

        override fun onError(errorMessage: String?) {
            Timber.e(errorMessage)
        }

    })

    private fun initRecyclerView() {
        binding.rvSearchUsers.apply {
            layoutManager = LinearLayoutManager(this@SearchUserActivity)
            adapter = rvAdapter
            addItemDecoration(
                CustomRvMargin(
                    this@SearchUserActivity,
                    16,
                    CustomRvMargin.LINEAR_VERTICAL
                )
            )
        }
    }

    private fun performSearchUser(refresh: Boolean) {
        val searchQuery = binding.etSearchUser.text.toString()
        if (searchQuery.isNotEmpty()) {
            binding.rvSearchUsers.isVisible = false
            binding.tvSearchNoItem.isVisible = false
            presenter.searchUsers(searchQuery, refresh)
        }
    }

    override fun onDestroy() {
        presenter.destroy()
        super.onDestroy()
    }
}