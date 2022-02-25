/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.domain.base

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version BaseUseCase, v 2.0 2/24/2022 3:30 PM by Arif R Gilang P
 */
abstract class BaseSingleUseCase<in Params, Result> constructor(
    private val jobScheduler: Scheduler = Schedulers.io(),
    private val postScheduler: Scheduler = AndroidSchedulers.mainThread()
) {

    private val disposable = CompositeDisposable()

    /**
     * Build observable use case.
     *
     * @param params Use [NoParams] if you don't mind to pass any parameter.
     */
    abstract fun buildUseCase(params: Params): Single<Result>

    @JvmOverloads
    fun execute(
        params: Params,
        onSuccess: OnSuccessCallback<Result>,
        onError: OnErrorCallback = {}
    ) {
        execute(params, onSuccess, onError, {})
    }

    fun execute(
        params: Params,
        onSuccess: OnSuccessCallback<Result>,
        onError: OnErrorCallback = {},
        onDispose: Action = Action { }
    ) {
        buildUseCase(params)
            .subscribeOn(jobScheduler)
            .observeOn(postScheduler)
            .doOnDispose(onDispose)
            .subscribe({
                onSuccess(it)
                dispose()
            }, {
                Timber.e(it)
                onError(it)
                dispose()
            })
            .let { disposable.add(it) }
    }

    fun dispose() {
        disposable.clear()
    }
}