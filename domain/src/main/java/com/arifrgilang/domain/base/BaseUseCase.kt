/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.domain.base

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Action
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * This **auto-dispose** UseCase class helps you to avoid memory leak when you forget to dispose
 * [Observable].
 *
 * * For [Single], use [SingleUseCase]
 * * For [Observable], use [BaseUseCase]
 *
 * @author Anggrayudi Hardiannico A. (anggrayudi.hardiannico@dana.id)
 * @version BaseUseCase.kt, v 0.0.1 2020-02-25 13:22 by Anggrayudi Hardiannico A.
 * @see CancellableUseCase
 * @see CompletableUseCase
 */
abstract class BaseUseCase<Params, T> () {

    private val disposable = CompositeDisposable()

    /**
     * Build observable use case.
     *
     * @param params Use [NoParams] if you don't mind to pass any parameter.
     */
    abstract fun buildUseCase(params: Params): Observable<T>

    @JvmOverloads
    fun execute(
        params: Params,
        onSuccess: OnSuccessCallback<T>,
        onError: OnErrorCallback = {}
    ) {
        execute(params, onSuccess, onError, null) {}
    }

    fun execute(
        params: Params,
        onSuccess: OnSuccessCallback<T>,
        onError: OnErrorCallback = {},
        onComplete: OnCompleteCallback = {}
    ) {
        execute(params, onSuccess, onError, onComplete) {}
    }

    fun execute(
        params: Params,
        onSuccess: OnSuccessCallback<T>,
        onError: OnErrorCallback = {},
        onComplete: OnCompleteCallback? = {},
        onDispose: Action = Action {}
    ) {
        print("test")
        buildUseCase(params)
            .subscribeOn(UseCaseSchedulers.jobScheduler)
            .observeOn(UseCaseSchedulers.postScheduler)
            .doOnDispose(onDispose)
            .subscribe({
                onSuccess(it)
            }, {
                Timber.e(it, getSubclassPath())
                onError(it)
                dispose()
            }, {
                onComplete?.invoke()
                dispose()
            })
            .let { disposable.add(it) }
    }

    private fun getSubclassPath(): String =
        this.javaClass.asSubclass(this.javaClass).name ?: "Unknown"

    @JvmOverloads
    fun executeInBackground(
        params: Params,
        onSuccess: OnSuccessCallback<T>,
        onError: OnErrorCallback = {}
    ) {
        executeInBackground(params, onSuccess, onError, null) {}
    }

    fun executeInBackground(
        params: Params,
        onSuccess: OnSuccessCallback<T>,
        onError: OnErrorCallback = {},
        onComplete: OnCompleteCallback? = {},
        onDispose: Action = Action {}
    ) {
        buildUseCase(params)
            .subscribeOn(UseCaseSchedulers.jobScheduler)
            .doOnDispose(onDispose)
            .subscribe({
                onSuccess(it)
            }, {
                Timber.e(it, getSubclassPath())
                onError(it)
                dispose()
            }, {
                onComplete?.invoke()
                dispose()
            })
            .let { disposable.add(it) }
    }

    fun dispose() {
        disposable.clear()
    }
}