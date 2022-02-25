/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.domain.base

/**
 * Used to satisfy generic type of `Params` in use case classes. Example:
 *
 * ```kotlin
 * class TestCase : BaseUseCase<Int, NoParams>() {
 *
 *     override fun buildUseCase(params: NoParams): Observable<Int> {
 *         return Observable.just(1)
 *     }
 * }
 * ```
 *
 * Then,
 *
 * ```kotlin
 * val testCase = TestCase()
 * testCase.execute(NoParams, onSuccess = {}, onError = {})
 * ```
 *
 * @author Anggrayudi Hardiannico A. (anggrayudi.hardiannico@dana.id)
 * @version NoParams.kt, v 0.0.1 2020-02-25 16:35 by Anggrayudi Hardiannico A.
 */
object NoParams {

    override fun toString() = "id.dana.usecase.NoParams"
}