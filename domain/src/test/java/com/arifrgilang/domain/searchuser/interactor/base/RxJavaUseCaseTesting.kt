/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.domain.searchuser.interactor.base

import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version RxJavaTestingClass, v 2.0 04/03/22 17.53 by Arif R Gilang P
 */
open class RxJavaUseCaseTesting() {

    @Before
    fun setUp() {
        RxAndroidPlugins.setMainThreadSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
    }
}