/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.domain.base

/**
 * @author Anggrayudi Hardiannico A. (anggrayudi.hardiannico@dana.id)
 * @version UseCaseCallbacks.kt, v 0.0.1 2020-02-25 20:18 by Anggrayudi Hardiannico A.
 */

typealias OnSuccessCallback<T> = (T) -> Unit

typealias OnErrorCallback = (Throwable) -> Unit

typealias OnCompleteCallback = () -> Unit

typealias OnCancelCallback = () -> Unit