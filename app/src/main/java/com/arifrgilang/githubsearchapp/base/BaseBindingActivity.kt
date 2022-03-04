package com.arifrgilang.githubsearchapp.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.arifrgilang.githubsearchapp.GitHubSearchApp

/**
 * Created by arifrgilang on 4/14/2021
 */
abstract class BaseBindingActivity<T : ViewDataBinding> : AppCompatActivity() {

    @LayoutRes
    protected abstract fun contentView(): Int
    protected abstract fun setupData(savedInstanceState: Bundle?)
    protected abstract fun setupView()
    protected lateinit var binding: T
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, contentView())
        setupData(savedInstanceState)
        setupView()
    }

    protected fun getApplicationComponent() = (application as GitHubSearchApp).getApplicationComponent()
}