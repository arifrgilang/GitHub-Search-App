/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.domain

import io.reactivex.disposables.CompositeDisposable

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version BaseUseCase, v 2.0 2/24/2022 3:30 PM by Arif R Gilang P
 */
abstract class BaseSingleUseCase<in Parameter, out Result> {
    private val disposable = CompositeDisposable()

//    operator fun invoke(params: Parameter): Observable<Result>
}