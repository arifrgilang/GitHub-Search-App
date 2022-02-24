/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.githubsearchapp.searchuser.adapter

import android.content.Context
import android.view.ViewGroup
import com.arifrgilang.githubsearchapp.R
import com.arifrgilang.githubsearchapp.base.BaseRecyclerAdapter
import com.arifrgilang.githubsearchapp.databinding.ItemUserBinding
import com.arifrgilang.githubsearchapp.searchuser.model.UserModel
import javax.inject.Inject

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version SearchUserAdapter, v 2.0 2/24/2022 3:10 PM by Arif R Gilang P
 */
class SearchUserAdapter @Inject constructor(
    context: Context
): BaseRecyclerAdapter<UserModel, ItemUserBinding, SearchUserAdapter.ViewHolder>(context) {
    override fun getResLayout(type: Int): Int = R.layout.item_user

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(initViewBinding(viewType, parent))

    inner class ViewHolder(itemView: ItemUserBinding): BaseViewHolder(itemView) {
        override fun onBind(model: UserModel) {
            view.user = model
        }
    }
}