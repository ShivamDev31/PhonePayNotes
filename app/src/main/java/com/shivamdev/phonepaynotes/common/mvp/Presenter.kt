package com.koifolio.features.base

import com.shivamdev.phonepaynotes.common.mvp.BaseView

/**
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the BaseView type that wants to be attached with.
 */
interface Presenter<in V : BaseView> {

    fun attachView(mvpView: V)

    fun detachView()
}