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
 * @version BasePresenter, v 2.0 2/24/2022 12:49 PM by Arif R Gilang P
 */

/**
 * Interface representing a Presenter in a model view presenter (MVP) pattern.
 * Credit by: https://github.com/aderayanbima31/Movie-OnBoardingApp
 */
interface BasePresenter {

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onResume() method.
     */
    fun resume()

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onPause() method.
     */
    fun pause()

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onDestroy() method.
     */
    fun destroy()
}