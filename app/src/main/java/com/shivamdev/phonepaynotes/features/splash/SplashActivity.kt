package com.shivamdev.phonepaynotes.features.splash

import com.koifolio.util.activityStarter
import com.shivamdev.phonepaynotes.R
import com.shivamdev.phonepaynotes.common.base.BaseActivity
import com.shivamdev.phonepaynotes.di.component.ActivityComponent
import com.shivamdev.phonepaynotes.features.home.HomeActivity

/**
 * Created by shivam on 19/01/18.
 */
class SplashActivity : BaseActivity<SplashPresenter>(), SplashView {

    override val layout: Int = R.layout.activity_splash

    override fun initView() {
        presenter.startHomeActivity()
    }

    override fun startHomeActivity() {
        activityStarter<HomeActivity>()
        finish()
    }

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun attachView() {
        presenter.attachView(this)
    }

}