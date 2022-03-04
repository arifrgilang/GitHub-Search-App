/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.githubsearchapp

import android.app.Application
import com.arifrgilang.data.di.NetworkModule
import com.arifrgilang.githubsearchapp.di.component.ApplicationComponent
import com.arifrgilang.githubsearchapp.di.component.DaggerApplicationComponent
import com.arifrgilang.githubsearchapp.di.module.ApplicationModule
import timber.log.Timber

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version GitHubSearchApp, v 2.0 2/24/2022 11:15 AM by Arif R Gilang P
 */
class GitHubSearchApp : Application() {

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        initializeInjector()
        initializeTimber()
//        initializeMMKV()
    }

    private fun initializeInjector() {
        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .networkModule(NetworkModule())
//            .useCaseModule(UseCaseModule())
            .build()
    }

    private fun initializeTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    fun getApplicationComponent() = applicationComponent

//    private fun initializeMMKV() {
//        MMKV.initialize(this)
//    }

}