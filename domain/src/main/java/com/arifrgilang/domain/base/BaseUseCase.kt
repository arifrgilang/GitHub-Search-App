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
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * @author Derayan Bima A (derayan.bima@dana.id)
 * @version UseCase, v 0.1 2019-06-14 11:03 by Derayan Bima A
 */
/**
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This interface represents a execution unit for different use cases (this means any use case
 * in the application should implement this contract).
 *
 * By convention each UseCase implementation will return the result using a [ ]
 * that will execute its job in a background thread and will post the result in UI thread.
 */
abstract class BaseUseCase<Params, T> constructor(
    private val threadExecutor: Scheduler = Schedulers.io(),
    private val postExecutionThread: Scheduler = AndroidSchedulers.mainThread()
) {

    private val disposables: CompositeDisposable = CompositeDisposable()

    /**
     * Executes the current use case.
     *
     * @param observer [DisposableObserver] which will be listening to the observer build
     * by [()][.buildUseCaseObservable] method.
     * @param params   Parameters (Optional) used to build/execute this use case.
     */
    fun execute(observer: DisposableObserver<T>, params: Params) {
        val observable = buildUseCaseObservable(params)
            .subscribeOn(threadExecutor)
            .observeOn(postExecutionThread)
        addDisposable(observable.subscribeWith(observer))
    }

    /**
     * Builds an [Observable] which will be used when executing the current [UseCase].
     */
    abstract fun buildUseCaseObservable(params: Params): Observable<T>

    /**
     * Dispose from current [CompositeDisposable].
     */
    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    /**
     * Dispose from current [CompositeDisposable].
     */
    fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }
}