package com.shivamdev.phonepaynotes.features.splash

import com.koifolio.features.base.BasePresenter
import com.koifolio.util.runDelayed
import com.shivamdev.phonepaynotes.common.constants.SPLASH_TIMEOUT
import javax.inject.Inject

/**
 * Created by shivam on 19/01/18.
 */
class SplashPresenter @Inject constructor() : BasePresenter<SplashView>() {

    fun startHomeActivity() {

        runDelayed(SPLASH_TIMEOUT, { view?.startHomeActivity() })

    }

}