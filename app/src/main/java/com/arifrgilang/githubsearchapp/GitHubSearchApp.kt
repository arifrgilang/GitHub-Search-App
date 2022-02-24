/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.githubsearchapp

import android.app.Application
import com.arifrgilang.githubsearchapp.di.component.AppComponent
import com.arifrgilang.githubsearchapp.di.DaggerAppComponent
import com.arifrgilang.githubsearchapp.di.module.AppModule
import timber.log.Timber

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version GitHubSearchApp, v 2.0 2/24/2022 11:15 AM by Arif R Gilang P
 */
class GitHubSearchApp: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initializeInjector()
        initializeTimber()
    }

    private fun initializeInjector() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    private fun initializeTimber() {
        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}