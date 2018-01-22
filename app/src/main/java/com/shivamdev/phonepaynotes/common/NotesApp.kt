package com.shivamdev.phonepaynotes.common

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.facebook.stetho.Stetho
import com.shivamdev.phonepaynotes.di.component.AppComponent
import com.shivamdev.phonepaynotes.di.component.DaggerAppComponent
import com.shivamdev.phonepaynotes.di.module.AppModule
import timber.log.Timber

/**
 * Created by shivam on 18/01/18.
 */
class NotesApp : Application() {

    lateinit var component: AppComponent
        private set

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        setupDagger()
        Timber.plant(Timber.DebugTree())
        Stetho.initializeWithDefaults(this)
    }

    private fun setupDagger() {
        component = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

    companion object {
        lateinit var instance: NotesApp
            private set
    }

}