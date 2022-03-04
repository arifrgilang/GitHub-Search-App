/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.domain.base

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version UseCaseSchedulers, v 2.0 04/03/22 06.51 by Arif R Gilang P
 */
object UseCaseSchedulers {

    @JvmStatic
    val jobScheduler: Scheduler =
        Schedulers.io()

    @JvmStatic
    val postScheduler: Scheduler =
        AndroidSchedulers.mainThread()
}