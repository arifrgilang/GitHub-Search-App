/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.githubsearchapp.searchuser

import android.os.Bundle
import com.arifrgilang.githubsearchapp.R
import com.arifrgilang.githubsearchapp.base.BaseBindingActivity
import com.arifrgilang.githubsearchapp.databinding.ActivitySearchUserBinding

class SearchUserActivity : BaseBindingActivity<ActivitySearchUserBinding>(),
                           SearchUserContract.View {

    override fun contentView(): Int = R.layout.activity_search_user

    override fun setupData(savedInstanceState: Bundle?) {
        // No Implementation yet
    }

    override fun setupView() {
        // No Implementation yet
    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun dismissProgress() {
        TODO("Not yet implemented")
    }

    override fun onError(errorMessage: String?) {
        TODO("Not yet implemented")
    }
}