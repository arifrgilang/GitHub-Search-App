/*
 *
 *   DANA.id
 *   PT. Espay Debit Indonesia Koe.
 *   Copyright (c) 2017-2022. All Rights Reserved.
 *
 */

package com.arifrgilang.githubsearchapp.base

/**
 * @author Arif R Gilang P (arif.rhizky@dana.id)
 * @version BaseView, v 2.0 02/03/22 11.04 by Arif R Gilang P
 */
interface BaseView {

    fun showProgress()
    fun dismissProgress()
    fun onError(errorMessage: String?)
}